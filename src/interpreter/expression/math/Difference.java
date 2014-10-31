package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

/**
 * Difference Expression
 * @author Will Chang
 *
 */

public class Difference extends MathExpression {
    @Override
    /**
     * Returns the difference between the values of the first
     * and second results.
     */
    protected double applyMath (Deque<SLogoResult> results) {
        return results.pop().getValue() - results.pop().getValue();
    }
}
