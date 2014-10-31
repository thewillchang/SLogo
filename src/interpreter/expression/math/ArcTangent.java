// This entire file is part of my masterpiece.
// William Chang
package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

/**
 * 
 * @author Will Chang
 *
 */

public class ArcTangent extends MathExpression {
    @Override
    /**
     * Returns the arctangent of the value of the first result in degress.
     */
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.toDegrees(Math.atan(results.pop().getValue()));
    }
}
