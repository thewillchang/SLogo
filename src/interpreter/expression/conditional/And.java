package interpreter.expression.conditional;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.TwoArgumentCommand;
import java.util.Deque;
import transitionstate.TransitionState;

/**
 * 
 * @author Will Chang
 *
 */
public class And extends ConditionalExpression {

    private SLogoExpression operand1;
    private SLogoExpression operand2;


    private Deque<SLogoExpression> myParameters;
    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        for(int i = 0 ; i < 2 ; i++) {
            try {
                myParameters.add(args.pop());
            }
            catch (NullPointerException e) {
                System.out.println("Empty Parameters List");
            }
        }
    }

    @Override
    public SLogoResult evaluate() {
        int value = (myParameters.pop().evaluate().getValue() > 0 && myParameters.pop().evaluate().getValue() > 0) ? 1 : 0;
        TransitionState state = new TransitionState();

        return new ConditionalResult(value, state);
    }


}
