package interpreter.expression.syntax;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import model.MainModel;
import model.UserDefinedVariablesModel;
import exceptions.SLogoParsingException;
import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;
import interpreter.SyntaxResult;
import interpreter.UserDefinedResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SyntaxExpression;

public class Command extends SyntaxExpression {
    private int myNumArgs;
    private String myName;
    private SLogoExpression myCommands;

    public Command() {
        super();
    }
    
    public Command (String name, SLogoExpression commands) {
        super();
        setValue(name);
        myCommands = commands;
        
    }

    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        if(myLibrary.getUserDefinedCommands().containsCommand(myName)) {
            for(int i = 0; i < myNumArgs; i++) {
                myArguments.add(args.pop());
            }
        }
    }

    @Override
    public SLogoResult evaluate () {


        UserDefinedVariablesModel myUserDefinedVariables = myLibrary.getUserDefinedVariables();
        if(myUserDefinedVariables.containsVariable(myValue)) {
            return new UserDefinedResult(myUserDefinedVariables.getVariable(myValue));
        }
        return new SyntaxResult(myValue);
    }

    @Override
    public void setValue (String value) {
        myName = value;

    }
    
    @Override
    public String toString() {
        return myName;
    }


}
