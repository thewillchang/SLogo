package interpreter.expression.turtlecommand;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;

import java.util.List;

import transitionstate.TransitionState;

public class ForwardCommand extends TurtleCommandExpression {
    private SLogoExpression[] myParameters;
    
    @Override
    public void loadArguments(List<SLogoExpression> args) {
        myParameters =  (SLogoExpression[]) args.toArray();
    }

    @Override
    public SLogoResult evaluate() {
        SLogoResult previousResult = myParameters[0].evaluate();
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
