package model;

import interpreter.Interpreter;
import interpreter.SLogoResult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import transitionstate.TransitionState;
import turtle.Turtle;
import viewcontroller.MainModelObserver;

/**
 * main model of program--contains and updates other models
 * @author Tanaka Jimha
 *
 */
public class MainModel {

	private List<MainModelObserver> myObservers;
	private Interpreter myInterpreter;
	private List<Turtle> myTurtles;
	private List<TransitionState> myTransitionState;
	private String language;
	private CommandHistoryModel myCommandHistoryModel;
	private UserDefinedMethodsModel myUserDefinedMethodsModel;
	private UserDefinedVariablesModel myUserDefinedVariablesModel;
	

	final String PROPERTIES_FILENAME = "SLogoState";
	final String LANGUAGE_PROPERTY = "Language";

	public MainModel(){
		this.myObservers = new ArrayList<>();
		this.myInterpreter = new Interpreter();
		this.myTransitionState = new ArrayList<TransitionState>();
		this.myTurtles = new ArrayList<>();
		this.myCommandHistoryModel = new CommandHistoryModel();
		this.myUserDefinedMethodsModel = new UserDefinedMethodsModel();
		this.myUserDefinedVariablesModel = new UserDefinedVariablesModel();
	}

	/**
	 * interprets a String SLogoCommand by passing it to the Interpreter
	 * @param sLogoCommand
	 */
	public void interpretSLogoCommand(String sLogoCommand) {
		SLogoResult myResult = myInterpreter.interpret(sLogoCommand);
		myTransitionState = myResult.getTransition();
		if(!myResult.getHasError()){
			myCommandHistoryModel.addCommand(sLogoCommand);
		}
		notifyObservers();
	}

	/**
	 * used to set the language in which the commands are written in
	 * @param language
	 */
	public void setLanguage(String languageName) {
		setProperty(LANGUAGE_PROPERTY, languageName);
		this.language = languageName;
	}
	
	public void attachObservers(Collection<MainModelObserver> observers) {
		for (MainModelObserver observer : observers) {
			myObservers.add(observer);
		}
	}
	
	private void notifyObservers() {
		for (MainModelObserver observer : myObservers) {
			observer.update(this);
		}
	}
	
	public CommandHistoryModel getCommandHistory() {
		return this.myCommandHistoryModel;
	}
	
	public UserDefinedMethodsModel getUserDefinedMethods() {
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

