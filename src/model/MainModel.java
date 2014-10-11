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

/**
 * main model of program--contains and updates other models
 * @author Tanaka Jimha
 *
 */
public class MainModel extends Observable{

	private Interpreter myInterpreter;
	private Turtle myTurtle;
	private Collection<TransitionState> myTransitionState;
	private String language;

	final String PROPERTIES_FILENAME = "SLogoState";
	final String LANGUAGE_PROPERTY = "Language";

	public MainModel(){

		this.myInterpreter = new Interpreter();
		this.myTurtle = new Turtle();
		this.myTransitionState = new ArrayList<TransitionState>();

	}

	/**
	 * interprets a String SLogoCommand by passing it to the Interpreter
	 * @param sLogoCommand
	 */
	public void interpretSLogoCommand(String sLogoCommand) {
		myTransitionState = myInterpreter.interpret(sLogoCommand).getTransition();
	}

	/**
	 * used to set the language in which the commands are written in
	 * @param language
	 */
	public void setLanguage(String languageName) {
		setProperty(LANGUAGE_PROPERTY, languageName);
		this.language = languageName;
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


