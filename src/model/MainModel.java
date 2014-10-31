package model;
import interpreter.Interpreter;
import interpreter.result.SLogoResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import transitionstate.TransitionState;
import turtle.Turtle;
import turtle.TurtleHistoryState;
import turtle.TurtleListHistory;
import viewcontroller.MainModelObserver;
import application.PenForm;
import application.PenFormResult;
/**
 * main model of program--contains and updates other models
 * 
 * @author Tanaka Jimha
 *
 */
public class MainModel {
	private final static Color DEFAULT_BACKGROUND_COLOR = Color.DARKBLUE;
	private Color myBackgroundColor;
	private boolean myTurtleAdded;
	private boolean myFailedParse;
	private List<MainModelObserver> myObservers;
	private transient Interpreter myInterpreter;
	private transient List<Turtle> myTurtles;
	private transient TurtleListHistory myTurtleListHistory;
	private SLogoResult mySLogoResult;
	private String myLanguage;
	private CommandHistoryModel myCommandHistoryModel;
	private UserDefinedCommandsModel myUserDefinedMethodsModel;
	private UserDefinedVariablesModel myUserDefinedVariablesModel;
	private double myAnimationSpeed;
	private transient ParallelTransition myAnimation;
	final String PROPERTIES_FILENAME = "SLogoState";
	final String LANGUAGE_PROPERTY = "Language";

	public MainModel(String language) {
		this.myLanguage = language;
		this.myObservers = new ArrayList<>();
		this.myTurtles = new ArrayList<>();
		this.myCommandHistoryModel = new CommandHistoryModel();
		this.myUserDefinedMethodsModel = new UserDefinedCommandsModel();
		this.myUserDefinedVariablesModel = new UserDefinedVariablesModel();
		this.myInterpreter = new Interpreter(this);
		this.myTurtleAdded = false;
		this.myAnimation = new ParallelTransition();
		this.myTurtleListHistory = new TurtleListHistory();
		this.myBackgroundColor = DEFAULT_BACKGROUND_COLOR;
	}
	
	public MainModel(String language, CommandHistoryModel cHM,
			UserDefinedCommandsModel uDCM, UserDefinedVariablesModel uDVM,
			String backGroundColor) {
		this.myLanguage = language;
		this.myObservers = new ArrayList<>();
		this.myTurtles = new ArrayList<>();
		this.myCommandHistoryModel = cHM;
		this.myUserDefinedMethodsModel = uDCM;
		this.myUserDefinedVariablesModel = uDVM;
		this.myInterpreter = new Interpreter(this);
		this.myTurtleAdded = false;
		this.myAnimation = new ParallelTransition();
		this.myTurtleListHistory = new TurtleListHistory();
		this.myBackgroundColor = myBackgroundColor.valueOf(backGroundColor);
	}
	public void changeTurtleImages(File file) {
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) {
				turtle.setImage(file);
			}
		}
	}
	public Color getBackgroundColor() {
		return myBackgroundColor;
	}
	public String getBackgroundColorName() {
		return myBackgroundColor.toString();
	}
	public void updateAnimationSpeed(double speed) {
		myAnimation.setRate(speed);
		myAnimationSpeed = speed;
	}
	public void setBackgroundColor(Color color) {
		myBackgroundColor = color;
		myAnimation = new ParallelTransition();
		notifyObservers();
	}
	
	public void updatePen(PenForm penForm) {
		PenFormResult penFormResult = penForm.getResult();
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) {
				turtle.getPen().setWidth(penFormResult.getPenWidth());
				turtle.getPen().update(!penFormResult.getPenUp());
				turtle.getPen().setDash(penFormResult.getPenDash());
			}
		}
	}
	public void updatePenColor(Color color) {
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) {
				turtle.getPen().setColor(color);
			}
		}
	}

	public Turtle getActiveTurtle() {
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) {
				return turtle;
			}
		}
		return null;
	}
	
	/**
	 * adds a turtle
	 */
	public void addTurtle() {
		myTurtles.add(new Turtle());
		myTurtleAdded = true;
		notifyObservers();
		myTurtleAdded = false;
	}	

	public List<Turtle> getTurtles() {
		return myTurtles;
	}
	public boolean isTurtleAdded() {
		return myTurtleAdded;
	}
	public SLogoResult getResult() {
		return mySLogoResult;
	}
	/**
	 * interprets a String SLogoCommand by passing it to the Interpreter
	 * 
	 * @param sLogoCommand
	 */
	public void interpretSLogoCommand(String sLogoCommand) {
		mySLogoResult = myInterpreter.interpret(sLogoCommand);
		myFailedParse = mySLogoResult.getHasError();
		if (!myFailedParse) {
			myCommandHistoryModel.addCommand(sLogoCommand);
			updateModel();
		}
		notifyObservers();
		myFailedParse = false;
	}

	public void interpretSLogoCommand(String commandKey, String operands) {
		Map<String, String> commandMap = myInterpreter
				.getCommandReferenceLibrary().getReferencesToCommands();
		String command = commandKey.trim() + " " + operands.trim();
		for (String key : commandMap.keySet()) {
			if (commandMap.get(key).equals(commandKey)) {
				command = key.trim() + " " + operands.trim();
			}
		}
		interpretSLogoCommand(command);
	}

	public boolean getFailedParse() {
		return myFailedParse;
	}

	private void updateModel() {
		ModelUpdater updater = new ModelUpdater();
		Map<Turtle, List<TransitionState>> turtleTransitionMap = updater
				.updateModel(myTurtles, mySLogoResult.getTransition());
		setMyAnimation(turtleTransitionMap);
	}
	private void setMyAnimation(Map<Turtle, List<TransitionState>> map) {
		myAnimation = new ParallelTransition();
		for (Turtle turtle : map.keySet()) {
			Animation animation = turtle.createAnimation(map.get(turtle));
			myAnimation.getChildren().add(animation);
		}
		myAnimation.setRate(myAnimationSpeed);
		myTurtleListHistory.updateList(map.keySet());
	}
	public ParallelTransition getAnimation() {
		return myAnimation;
	}
	/**
	 * used to set the language in which the commands are written in
	 * 
	 * @param myLanguage
	 */
	public void setLanguage(String languageName) {
		setProperty(LANGUAGE_PROPERTY, languageName);
		this.myLanguage = languageName;
	}
	public void attachObserver(MainModelObserver observer) {
		myObservers.add(observer);
	}
	private void notifyObservers() {
		for (MainModelObserver observer : myObservers) {
			observer.update(this);
		}
	}
	public CommandHistoryModel getCommandHistory() {
		return this.myCommandHistoryModel;
	}
	public UserDefinedCommandsModel getUserDefinedMethods() {
		return this.myUserDefinedMethodsModel;
	}
	public UserDefinedVariablesModel getUserDefinedVariables() {
		return this.myUserDefinedVariablesModel;
	}

	private void setProperty(String propertyName, String value) {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream(PROPERTIES_FILENAME);
			// set the properties value
			prop.setProperty(propertyName, value);
			// save properties to project root folder
			prop.store(output, null);
		} catch (IOException io) {
			//
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getLanguage () {
		return myLanguage;
	}
	public void undoClicked() {
		TurtleHistoryState state = myTurtleListHistory.undo();
		myAnimation = state.getAnimation();
		myAnimation.setRate(Math.abs(myAnimation.getRate()) * -1);
		for (Line line : state.getLines()) {
			line.setVisible(false);
		}
		notifyObservers();
	}
	public void redoClicked() {
		TurtleHistoryState state = myTurtleListHistory.redo();
		myAnimation = state.getAnimation();
		myAnimation.setRate(Math.abs(myAnimation.getRate()));
		for (Line line : state.getLines()) {
			line.setVisible(true);
		}
		notifyObservers();
	}

	public void setmyInterpreter() {
		this.myInterpreter = new Interpreter(this);
	}
}

