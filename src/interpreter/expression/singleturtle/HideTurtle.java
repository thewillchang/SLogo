package interpreter.expression.singleturtle;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import transitionstate.TransitionState;
/**
 * 
 * @author Will
 *
 */
public class HideTurtle extends TurtleCommandExpression {
    private Deque<SLogoExpression> myParameters;

    public HideTurtle () {
        myParameters = new ArrayDeque<>();
    }
    
    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
    }

    @Override
    public SLogoResult evaluate() {
        SLogoResult previousResult = myParameters.pop().evaluate();
        TransitionState nextTransition = new TransitionState(false, 
                                                             false, 
                                                             0, 
                                                             0,
                                                             0);
        SLogoResult myResult = new TurtleCommandResult(previousResult.getValue());
        myResult.getTransition().add(nextTransition);
        myResult.getTransition().addAll(previousResult.getTransition());
        return myResult;

    }

}
