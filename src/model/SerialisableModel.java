package model;

import interpreter.SLogoResult;
/**
 *A serialisable version of model which does not hold non serialisable
 *Javafx compnents and allows saving of some state in the model
 * 
 * @author Tanaka Jimha
 *
 */


import java.io.Serializable;
import java.util.List;

import turtle.SerialisableTurtle;

public class SerialisableModel implements Serializable {
	
	private SLogoResult mySLogoResult;
	private String myLanguage;
	private CommandHistoryModel myCommandHistoryModel;
	private UserDefinedCommandsModel myUserDefinedMethodsModel;
	private UserDefinedVariablesModel myUserDefinedVariablesModel;
	private String backGroundColorName;
	private List<SerialisableTurtle> mySerialisableTurtles;
	
	public SerialisableModel(MainModel model) {
		this.myLanguage = model.getLanguage();
		//this.myTurtles = new ArrayList<>();
		this.myCommandHistoryModel = model.getCommandHistory();
		this.myUserDefinedMethodsModel = model.getUserDefinedMethods();
		this.myUserDefinedVariablesModel = model.getUserDefinedVariables();
		this.backGroundColorName = model.getBackgroundColorName();
		//this.myInterpreter = new Interpreter(this);
		//myTurtleAdded = false;
		//myAnimation = new ParallelTransition();
		//myTurtleListHistory = new TurtleListHistory();
		//myBackgroundColor = DEFAULT_BACKGROUND_COLOR;
	}

	public String getMyLanguage() {
		return myLanguage;
	}

	public CommandHistoryModel getMyCommandHistoryModel() {
		return myCommandHistoryModel;
	}

	public UserDefinedCommandsModel getMyUserDefinedMethodsModel() {
		return myUserDefinedMethodsModel;
	}

	public UserDefinedVariablesModel getMyUserDefinedVariablesModel() {
		return myUserDefinedVariablesModel;
	}
	
	public String getBackGroundColorName(){
		return backGroundColorName;
	}

	public List<SerialisableTurtle> getMySerialisableTurtles() {
		return mySerialisableTurtles;
	}

	public void setMySerialisableTurtles(
			List<SerialisableTurtle> mySerialisableTurtles) {
		this.mySerialisableTurtles = mySerialisableTurtles;
	}
	

	
	
}
