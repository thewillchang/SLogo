package model;

import interpreter.Interpreter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Properties;

import transitionstate.TransitionState;
import turtle.Turtle;

/**
 * main model of program--contains and updates other models
 * @author Jonathan Tseng
 * @author Tanaka Jimha
 *
 */
public class MainModel extends Observable{

	Interpreter myInterpreter;
	Turtle myTurtle;
	Collection<TransitionState> myTransitionStates;

	final String PROPERTIES_FILENAME = "SLogoState";
	final String LANGUAGE_PROPERTY = "Language";

	public MainModel(){

		this.myInterpreter = new Interpreter();
		this.myTurtle = new Turtle();
		this.myTransitionStates = new ArrayList<TransitionState>();

	}

	/**
	 * interprets a String SLogoCommand by passing it to the Interpreter
	 * @param sLogoCommand
	 */
	public void interpretSLogoCommand(String sLogoCommand) {
		myInterpreter.interpret(sLogoCommand);
	}

	/**
	 * used to set the language in which the commands are written in
	 * @param language
	 */
	public void setLanguage(String languageName) {
		setProperty(LANGUAGE_PROPERTY, languageName);
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


