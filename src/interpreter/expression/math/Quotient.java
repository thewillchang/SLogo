package interpreter.expression.math;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.singleturtle.TurtleCommandExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import transitionstate.TransitionState;

public class Quotient extends MathExpression {
    private Deque<SLogoExpression> myParameters;

    public Quotient () {
        myParameters = new ArrayDeque<>();
    }
    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        try {
            myParameters.add(args.pop());
            myParameters.add(args.pop());
        }
        catch (NullPointerException e) {
            System.out.println("Empty Parameters List");
        }
    }

    @Override
    public SLogoResult evaluate() {
        SLogoResult numerator = myParameters.pop().evaluate();
        SLogoResult denominator = myParameters.pop().evaluate();

        double value = numerator.getValue()/denominator.getValue();

        TransitionState nextTransition = new TransitionState(false, 
                                                             true, 
                                                             value, 
                                                             0,
                                                             0);
        SLogoResult myResult = new MathResult(value);
        myResult.getTransition().add(nextTransition);
        myResult.getTransition().addAll(numerator.getTransition());
        myResult.getTransition().addAll(denominator.getTransition());
        return myResult;

    }

}
