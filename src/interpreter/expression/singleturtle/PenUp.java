package interpreter.expression.singleturtle;

import interpreter.SLogoResult;
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
    protected void setNextTransition (SLogoResult myResult, double value) {
        myResult.getTransition().add(new TransitionState(PenChange.CHANGE_UP, VisibleChange.NO_CHANGE, 0, 0, 0));
    }
}