package interpreter.expression.singleturtle;

import interpreter.SLogoResult;
import transitionstate.TransitionState;
import transitionstate.TransitionState.PenChange;
import transitionstate.TransitionState.VisibleChange;

public class PenDown extends TurtleCommandExpression {
    public PenDown () {
        super();
    }
    
    @Override
    protected void setNextTransition (SLogoResult myResult, double value) {
        myResult.getTransition().add(new TransitionState(PenChange.CHANGE_DOWN, VisibleChange.NO_CHANGE, 0, 0, 0));
        
    }
}