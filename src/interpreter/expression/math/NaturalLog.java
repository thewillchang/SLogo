package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
/**
 * Natural Log Expression
 * @author Will Chang
 *
 */
public class NaturalLog extends MathExpression {
    @Override
    /**
     * Takes the natural log of the value of the first result.
     */
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.log(results.pop().getValue());
    }
}
