package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
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
