package interpreter.expression.syntax;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import exceptions.SLogoParsingException;
import transitionstate.TransitionState;
import model.UserDefinedCommandsModel;
import model.UserDefinedVariablesModel;
import interpreter.SLogoResult;
import interpreter.SyntaxResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SyntaxExpression;

public class Command extends SyntaxExpression {
    
    private SLogoExpression myCommands;
    private List<String> myVariableReferences;

    public Command() {
        super();
        myVariableReferences = new ArrayList<>();
    }

    public Command (String name, SLogoExpression commands) {
        super();
        setValue(name);
        myCommands = commands;

    }

    @Override
    public void loadArguments(Deque<SLogoExpression> args) throws SLogoParsingException, NullPointerException {
        
        UserDefinedCommandsModel allDefinedCommands = myLibrary.getUserDefinedCommands();
        if(allDefinedCommands.containsCommand(myValue)) {
            myVariableReferences = allDefinedCommands.getVariablesForCommand(myValue);
            myNumArgs = myVariableReferences.size();
            for(int i = 0; i < myNumArgs; i++) {
                myArguments.add(args.pop());
            }
            myCommands = allDefinedCommands.getCommand(myValue);
        }
    }

    @Override
    public SLogoResult evaluate () {
        UserDefinedCommandsModel myUserDefinedCommands = myLibrary.getUserDefinedCommands();
        UserDefinedVariablesModel myUserDefinedVariables = myLibrary.getUserDefinedVariables();
        SLogoResult myResult = new SyntaxResult(myValue);

        Deque<SLogoExpression> copyArguments = new ArrayDeque<>(myArguments);

        if(myUserDefinedCommands.containsCommand(myValue)) {
            List<TransitionState> transitionStates = myResult.getTransition();
            
            if(myNumArgs > 0) {
                for(String variableName : myVariableReferences) {
                    SLogoResult result = copyArguments.pop().evaluate();
                    myUserDefinedVariables.putVariable(variableName, result.getValue());
                    transitionStates.addAll(result.getTransition());
                }
                
            }
            
            SLogoResult result = myCommands.evaluate();
            transitionStates.addAll(result.getTransition());
            myResult.setValue(result.getValue());
            for(String variableName : myVariableReferences) {
                myUserDefinedVariables.remove(variableName);
            }
        }
        return myResult;
    }
    @Override
    public String toString() {
        return myValue;
    }


}
