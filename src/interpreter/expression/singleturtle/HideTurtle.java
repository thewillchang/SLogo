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
public class HideTurtle extends TurtleCommandExpression {
    public HideTurtle () {
        super();
    }
    
    @Override
    protected void setNextTransition (SLogoResult myResult, double value) {
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, VisibleChange.CHANGE_INVISIBLE, 0, 0, 0));
        
    }
}
