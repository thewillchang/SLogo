package interpreter.expression.math;

import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;


/**
 *
 * @author Will Chang
 *
 */

public class Difference extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return results.pop().getValue() - results.pop().getValue();
    }
}
