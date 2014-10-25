package interpreter.expression.singleturtle;

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
public class Left extends TurtleCommandExpression {
    
    @Override
    protected void setNextTransition (SLogoResult myResult, double value) {
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, VisibleChange.NO_CHANGE, 0, 0, value));
        
    }
}