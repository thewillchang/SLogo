package model;

import interpreter.SLogoResult;

import java.io.Serializable;

public class SerialisableModel implements Serializable {
	
	private SLogoResult mySLogoResult;
	private String myLanguage;
	private CommandHistoryModel myCommandHistoryModel;
	private UserDefinedCommandsModel myUserDefinedMethodsModel;
	private UserDefinedVariablesModel myUserDefinedVariablesModel;
	private String backGroundColorName;
	
	public SerialisableModel(MainModel model) {
		this.myLanguage = model.getLanguage();
		//this.myObservers= ;
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
	
	
}
