package interpreter.expression.math;

import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;


/**
 *
 * @author Will
 *
 */
public class Sum extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double sum = 0;
        while (!results.isEmpty()) {
            sum += results.pop().getValue();
        }
        return sum;
    }
}
