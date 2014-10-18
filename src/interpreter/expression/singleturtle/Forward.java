package interpreter.expression.singleturtle;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
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
    private Deque<SLogoExpression> myParameters;

    public Forward () {
        super();
    }
    
    @Override
    protected void setNextTransition (SLogoResult myResult, double value) {
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, VisibleChange.NO_CHANGE, value,0,0));
        
    }

}
