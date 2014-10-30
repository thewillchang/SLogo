package model;

import interpreter.result.SLogoResult;
import java.io.Serializable;


/**
 * Serialisable Version of the MainModel which doesn't hold the non serialisable javafx components
 *
 * @author Tanaka Jimha
 *
 */
public class SerialisableModel implements Serializable {

    private SLogoResult mySLogoResult;
    private String myLanguage;
    private CommandHistoryModel myCommandHistoryModel;
    private UserDefinedCommandsModel myUserDefinedMethodsModel;
    private UserDefinedVariablesModel myUserDefinedVariablesModel;
    private String backGroundColorName;

    public SerialisableModel (MainModel model) {
        myLanguage = model.getLanguage();
        // this.myObservers= ;
        // this.myTurtles = new ArrayList<>();
        myCommandHistoryModel = model.getCommandHistory();
        myUserDefinedMethodsModel = model.getUserDefinedMethods();
        myUserDefinedVariablesModel = model.getUserDefinedVariables();
        backGroundColorName = model.getBackgroundColorName();
        // this.myInterpreter = new Interpreter(this);
        // myTurtleAdded = false;
        // myAnimation = new ParallelTransition();
        // myTurtleListHistory = new TurtleListHistory();
        // myBackgroundColor = DEFAULT_BACKGROUND_COLOR;
    }

    public String getMyLanguage () {
        return myLanguage;
    }

    public CommandHistoryModel getMyCommandHistoryModel () {
        return myCommandHistoryModel;
    }

    public UserDefinedCommandsModel getMyUserDefinedMethodsModel () {
        return myUserDefinedMethodsModel;
    }

    public UserDefinedVariablesModel getMyUserDefinedVariablesModel () {
        return myUserDefinedVariablesModel;
    }

    public String getBackGroundColorName () {
        return backGroundColorName;
    }

}
