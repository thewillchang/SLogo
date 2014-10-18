package interpreter.expression.math;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.singleturtle.TurtleCommandExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import transitionstate.TransitionState;

public class NaturalLog extends MathExpression {

    private Deque<SLogoExpression> myParameters;

    public NaturalLog () {
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
        SLogoResult previousResult = myParameters.pop().evaluate();

        double value = Math.log(previousResult.getValue());

        TransitionState nextTransition = new TransitionState(false, 
                                                             true, 
                                                             value, 
                                                             0,
                                                             0);
        SLogoResult myResult = new MathResult(value);
        myResult.getTransition().add(nextTransition);
        myResult.getTransition().addAll(previousResult.getTransition());
        return myResult;

    }

}
