package interpreter.expression.math;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.TurtleCommandExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import transitionstate.TransitionState;

/**
 * 
 * @author Will
 *
 */

public class Tangent extends MathExpression {

    private Deque<SLogoExpression> myParameters;

    public Tangent () {
        myParameters = new ArrayDeque<>();
    }
    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        try {
            myParameters.add(args.pop());
        }
        catch (NullPointerException e) {
            System.out.println("Empty Parameters List");
        }
    }

    @Override
    public SLogoResult evaluate() {
        SLogoResult param = myParameters.pop().evaluate();

        double value = Math.tan(param.getValue());

        TransitionState nextTransition = new TransitionState(false, 
                                                             true, 
                                                             value, 
                                                             0,
                                                             0);
        SLogoResult myResult = new MathResult(value);
        myResult.getTransition().add(nextTransition);
        myResult.getTransition().addAll(param.getTransition());
        return myResult;

    }
}
