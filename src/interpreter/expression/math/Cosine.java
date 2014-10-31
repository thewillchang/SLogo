package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
/**
 * Cosine Expression
 * @author Will Chang
 *
 */
public class Cosine extends MathExpression {
    @Override
    /**
     * Returns the cosine of the value of the first result in radians.
     */
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.cos(Math.toRadians(results.pop().getValue()));
    }
}
