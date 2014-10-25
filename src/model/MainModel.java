package model;

import interpreter.Interpreter;
import interpreter.SLogoResult;

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

/**
 * main model of program--contains and updates other models
 * @author Tanaka Jimha
 *
 */
public class MainModel {

	private final static Color DEFAULT_BACKGROUND_COLOR = Color.DARKBLUE;
		
	private Color myBackgroundColor;
	private boolean myTurtleAdded;
	private boolean myFailedParse;
	private List<MainModelObserver> myObservers;
	private Interpreter myInterpreter;
	private List<Turtle> myTurtles;
	private TurtleListHistory myTurtleListHistory;
	private SLogoResult mySLogoResult;
	private String myLanguage;
	private CommandHistoryModel myCommandHistoryModel;
	private UserDefinedCommandsModel myUserDefinedMethodsModel;
	private UserDefinedVariablesModel myUserDefinedVariablesModel;
	
	private ParallelTransition myAnimation;

	final String PROPERTIES_FILENAME = "SLogoState";
	final String LANGUAGE_PROPERTY = "Language";

	public MainModel(String language){
		this.myObservers = new ArrayList<>();
		this.myInterpreter = new Interpreter(this);
		this.myTurtles = new ArrayList<>();
		this.myCommandHistoryModel = new CommandHistoryModel();
		this.myUserDefinedMethodsModel = new UserDefinedCommandsModel();
		this.myUserDefinedVariablesModel = new UserDefinedVariablesModel();
		myTurtleAdded = false;
		myAnimation = new ParallelTransition();
		myTurtleListHistory = new TurtleListHistory();
		myBackgroundColor = DEFAULT_BACKGROUND_COLOR;
		myLanguage = language;
	}
	
	public void changeTurtleImages(File file) {
		for (Turtle turtle : myTurtles) {
			turtle.setImage(file);
		}
	}
	
	public Color getBackgroundColor() {
		return myBackgroundColor;
	}
	
	public void setBackgroundColor(Color color) {
		myBackgroundColor = color;
		myAnimation = new ParallelTransition();
		notifyObservers();
	}
	
	public void updatePenColor(Color color) {
		for (Turtle turtle : myTurtles) {
			turtle.getPen().setColor(color);
		}
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
	
	public void updateUserDefinedVariable(String variable, double value) {
		myUserDefinedVariablesModel.put(variable, value);
	}
	
	/**
	 * interprets a String SLogoCommand by passing it to the Interpreter
	 * @param sLogoCommand
	 */
	public void interpretSLogoCommand(String sLogoCommand) {
		mySLogoResult = myInterpreter.interpret(sLogoCommand);
		myFailedParse = mySLogoResult.getHasError();
		if(!mySLogoResult.getHasError()){
			myCommandHistoryModel.addCommand(sLogoCommand);
			updateModel();
		}
		notifyObservers();
		myFailedParse = false;
	}

	public boolean failedParse() {
		return myFailedParse;
	}
	
	private void updateModel() {
		ModelUpdater updater = new ModelUpdater();
		Map<Turtle, List<TransitionState>>  turtleTransitionMap = 
				updater.updateModel(myTurtles, mySLogoResult.getTransition());
		setMyAnimation(turtleTransitionMap);
	}
	
	private void setMyAnimation(Map<Turtle, List<TransitionState>> map) {
		myAnimation = new ParallelTransition();
		for (Turtle turtle : map.keySet()) {
			Animation animation = turtle.createAnimation(map.get(turtle));
			myAnimation.getChildren().add(animation);
		}
		myTurtleListHistory.updateList(map.keySet());
	}
	
	public ParallelTransition getAnimation() {
		return myAnimation;
	}
	
	/**
	 * used to set the language in which the commands are written in
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
	
	private void setProperty(String propertyName, String value){
		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(PROPERTIES_FILENAME);
			// set the properties value
			prop.setProperty(propertyName, value);
			// save properties to project root folder
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
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
	
}

