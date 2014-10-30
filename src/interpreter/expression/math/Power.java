package interpreter.expression.math;

import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;


/**
 *
 * @author Will
 *
 */
public class Power extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double base = results.pop().getValue();
        double power = results.pop().getValue();
        return Math.pow(base, power);
    }
}
