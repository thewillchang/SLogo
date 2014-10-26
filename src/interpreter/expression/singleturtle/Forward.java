package interpreter.expression.singleturtle;

import interpreter.expression.SLogoExpression;
import interpreter.expression.TurtleCommandExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;
import transitionstate.TransitionState;
import transitionstate.TransitionState.PenChange;
import transitionstate.TransitionState.VisibleChange;

/**
 * 
 * @author Will Chang
 *
 */
public class Forward extends TurtleCommandExpression {
    public Forward () {
        super();
    }
    
    @Override
    protected void setNextTransition (SLogoResult myResult, Deque<Double> values) {
        Double value = values.peek();
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, 
                                                         VisibleChange.NO_CHANGE, value,0,0));
        myResult.setValue(value);
    }

}
