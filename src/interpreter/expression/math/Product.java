package interpreter.expression.math;


import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.singleturtle.TurtleCommandExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import transitionstate.TransitionState;

public class Product extends MathExpression{
    
    private Deque<SLogoExpression> myParameters;

    public Product () {
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
        SLogoResult param1 = myParameters.pop().evaluate();
        SLogoResult param2 = myParameters.pop().evaluate();

        double value = param1.getValue() * param2.getValue();

        TransitionState nextTransition = new TransitionState(false, 
                                                             true, 
                                                             value, 
                                                             0,
                                                             0);
        SLogoResult myResult = new MathResult(value);
        myResult.getTransition().add(nextTransition);
        myResult.getTransition().addAll(param1.getTransition());
        myResult.getTransition().addAll(param2.getTransition());
        return myResult;

    }

}
