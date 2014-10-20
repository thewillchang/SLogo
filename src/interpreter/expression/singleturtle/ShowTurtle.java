package interpreter.expression.singleturtle;
import interpreter.SLogoResult;
import transitionstate.TransitionState;
import transitionstate.TransitionState.PenChange;
import transitionstate.TransitionState.VisibleChange;

public class ShowTurtle extends TurtleCommandExpression {
    
    @Override
    protected void setNextTransition (SLogoResult myResult, double value) {
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, VisibleChange.CHANGE_VISIBLE, 0, 0, 0));
        
    }
}