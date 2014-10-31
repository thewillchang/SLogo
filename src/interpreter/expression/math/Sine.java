package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
/**
 * Sine Expression
 * @author Will
 *
 */
public class Sine extends MathExpression {
    @Override
    /**
     * Returns sine of first value in results in radians.
     */
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.sin(Math.toRadians(results.pop().getValue()));
    }
}
