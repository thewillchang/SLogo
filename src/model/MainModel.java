package model;

import interpreter.Interpreter;
import interpreter.SLogoResult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import turtle.Turtle;
import viewcontroller.MainModelObserver;

/**
 * main model of program--contains and updates other models
 * @author Tanaka Jimha
 *
 */
public class MainModel {

	private boolean myTurtleAdded;
	private List<MainModelObserver> myObservers;
	private Interpreter myInterpreter;
	private List<Turtle> myTurtles;
	private SLogoResult mySLogoResult;
	private String myLanguage;
	private CommandHistoryModel myCommandHistoryModel;
	private UserDefinedCommandsModel myUserDefinedMethodsModel;
	private UserDefinedVariablesModel myUserDefinedVariablesModel;
	

	final String PROPERTIES_FILENAME = "SLogoState";
	final String LANGUAGE_PROPERTY = "Language";

	public MainModel(){
		this.myObservers = new ArrayList<>();
		this.myInterpreter = new Interpreter(this);
		this.myTurtles = new ArrayList<>();
		this.myCommandHistoryModel = new CommandHistoryModel();
		this.myUserDefinedMethodsModel = new UserDefinedCommandsModel();
		this.myUserDefinedVariablesModel = new UserDefinedVariablesModel();
		myTurtleAdded = false;
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
	 * @param sLogoCommand
	 */
	public void interpretSLogoCommand(String sLogoCommand) {
		mySLogoResult = myInterpreter.interpret(sLogoCommand);
		if(!mySLogoResult.getHasError()){
			myCommandHistoryModel.addCommand(sLogoCommand);
		}
		notifyObservers();
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
}

