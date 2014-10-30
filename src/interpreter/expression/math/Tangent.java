package interpreter.expression.math;

import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;


/**
 *
 * @author Will
 *
 */

public class Tangent extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.tan(Math.toRadians(results.pop().getValue()));
    }
}
