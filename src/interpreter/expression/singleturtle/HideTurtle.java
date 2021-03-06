package interpreter.expression.singleturtle;

import java.util.Deque;
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
public class HideTurtle extends TurtleCommandExpression {
    
    @Override
    protected void setNextTransition (SLogoResult myResult, Deque<Double> values) {
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, 
                                                         VisibleChange.CHANGE_INVISIBLE, 0, 0, 0));
    }
}
