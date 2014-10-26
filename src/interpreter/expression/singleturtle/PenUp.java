package interpreter.expression.singleturtle;

import java.util.Deque;
import java.util.List;
import interpreter.expression.TurtleCommandExpression;
import interpreter.result.SLogoResult;
import transitionstate.TransitionState;
import transitionstate.TransitionState.PenChange;
import transitionstate.TransitionState.VisibleChange;

/**
 * 
 * @author Will
 *
 */

public class PenUp extends TurtleCommandExpression {
    
    @Override
    protected void setNextTransition (SLogoResult myResult, Deque<Double> values) {
        myResult.getTransition().add(new TransitionState(PenChange.CHANGE_UP, VisibleChange.NO_CHANGE, 0, 0, 0));
    }
    
}