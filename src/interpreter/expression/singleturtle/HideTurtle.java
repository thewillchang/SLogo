package interpreter.expression.singleturtle;

import interpreter.SLogoResult;
import interpreter.expression.TurtleCommandExpression;
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
    protected void setNextTransition (SLogoResult myResult, double value) {
        myResult.setValue(0);
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, VisibleChange.CHANGE_INVISIBLE, 0, 0, 0));
        
    }
}
