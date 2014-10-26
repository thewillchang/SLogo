package interpreter.expression.singleturtle;

import java.util.Deque;
import interpreter.SLogoResult;
import interpreter.expression.TurtleCommandExpression;
import transitionstate.TransitionState;
import transitionstate.TransitionState.PenChange;
import transitionstate.TransitionState.VisibleChange;

/**
 * 
 * @author Will Chang
 *
 */
public class Backward extends TurtleCommandExpression {
    
    @Override
    protected void setNextTransition (SLogoResult myResult, Deque<Double> values) {
        Double value = values.peek();
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, 
                                                         VisibleChange.NO_CHANGE, (-1)*value, 0, 0));
        myResult.setValue(value);
        
    }
}
