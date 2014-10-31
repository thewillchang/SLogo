package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
/**
 * Product Expression
 * @author Will
 *
 */
public class Product extends MathExpression{
    @Override
    /**
     * Returns the product of the values of all results.
     */
    protected double applyMath (Deque<SLogoResult> results) {
        double value = 1;
        while(!results.isEmpty()) {
            value *= results.pop().getValue();
        }
        return value;
    }
}
