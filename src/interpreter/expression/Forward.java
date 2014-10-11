package interpreter.expression;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;

public class Forward extends TurtleCommandExpression {
    private Deque<SLogoExpression> myParameters;
    
    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        myParameters =  args;
    }

    @Override
    public SLogoResult evaluate() {
        SLogoResult previousResult = myParameters.pop().evaluate();
        TransitionState prevTransition = previousResult.getTransition().get(0);
        TransitionState nextTransition = new TransitionState(prevTransition.getPenUp(), 
                                                             prevTransition.getTurtleVisible(), 
                                                             previousResult.getValue(), 
                                                             prevTransition.getRotateClockwise(),
                                                             prevTransition.getRotateCounterClockwise());
        SLogoResult myResult = new TurtleCommandResult(previousResult.getValue());
        myResult.getTransition().add(nextTransition);
        myResult.getTransition().addAll(previousResult.getTransition());
        return myResult;
        
    }


}
