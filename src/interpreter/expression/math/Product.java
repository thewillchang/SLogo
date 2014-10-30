package interpreter.expression.math;

import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;


/**
 *
 * @author Will
 *
 */
public class Product extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double value = 1;
        while (!results.isEmpty()) {
            value *= results.pop().getValue();
        }
        return value;
    }
}
