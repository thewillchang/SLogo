package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

/**
 * Tangent Expression
 * @author Will
 *
 */

public class Tangent extends MathExpression {

    @Override
    /**
     * Returns tangent of value of first result in radians
     */
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.tan(Math.toRadians(results.pop().getValue()));
    }
}
