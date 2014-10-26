package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
/**
 * 
 * @author Will Chang
 *
 */
public class Cosine extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.cos(Math.toRadians(results.pop().getValue()));
    }
}
