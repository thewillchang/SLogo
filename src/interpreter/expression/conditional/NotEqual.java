package interpreter.expression.conditional;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.TwoArgumentCommand;
import java.util.ArrayDeque;
import java.util.Deque;
import transitionstate.TransitionState;
/**
 * 
 * @author Will Chang
 *
 */

public class NotEqual extends TwoArgumentCommand {
    
    
    private Deque<SLogoExpression> myParameters;

    private SLogoExpression operand1;
    private SLogoExpression operand2;


    public NotEqual () {
        myParameters = new ArrayDeque<>();
    }

    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        super.loadArguments(args);
    }

    @Override
    public SLogoResult evaluate() {
        int value = (operand1.evaluate().getValue() != operand2.evaluate().getValue()) ? 1 : 0;
        TransitionState state = new TransitionState();

        return new ConditionalResult(value, state);
    }


}
