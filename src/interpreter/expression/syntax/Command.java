package interpreter.expression.syntax;

import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;
import model.UserDefinedCommandsModel;
import interpreter.SLogoResult;
import interpreter.SyntaxResult;
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


        UserDefinedCommandsModel myUserDefinedCommands = myLibrary.getUserDefinedCommands();
        SLogoResult myResult = new SyntaxResult(myValue);
        if(myUserDefinedCommands.containsCommand(myValue)) {
            List<TransitionState> transitionStates = myResult.getTransition(); 
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
