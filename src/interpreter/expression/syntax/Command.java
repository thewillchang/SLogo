package interpreter.expression.syntax;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;
import model.UserDefinedCommandsModel;
import model.UserDefinedVariablesModel;
import interpreter.SLogoResult;
import interpreter.SyntaxResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SyntaxExpression;

public class Command extends SyntaxExpression {
    private int myNumArgs;
    private String myName;
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
    public void loadArguments(Deque<SLogoExpression> args) {
        UserDefinedCommandsModel allDefinedCommands = myLibrary.getUserDefinedCommands();
        if(allDefinedCommands.containsCommand(myName)) {
            myVariableReferences = allDefinedCommands.getVariablesForCommand(myName);
            for(int i = 0; i < myVariableReferences.size() ; i++) {
                myArguments.add(args.pop());
            }
        }
    }

    @Override
    public SLogoResult evaluate () {
        UserDefinedCommandsModel myUserDefinedCommands = myLibrary.getUserDefinedCommands();
        UserDefinedVariablesModel myUserDefinedVariables = myLibrary.getUserDefinedVariables();
        SLogoResult myResult = new SyntaxResult(myValue);
        
        List<SLogoExpression> copyArguments = new ArrayList<>(myArguments);
        
        if(myUserDefinedCommands.containsCommand(myValue)) {
            List<TransitionState> transitionStates = myResult.getTransition(); 
            Deque<SLogoExpression> listVariables = copyArguments.get(0).evaluate().getGroupedExpressions();
            for(String variableName : myVariableReferences) {
                myVariables.put(variableName,)
            }
            
            SLogoResult result = myCommands.evaluate();
            transitionStates.addAll(result.getTransition());
            myResult.setValue(result.getValue());
        }
        return myResult;
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
