package interpreter.expression.math;

import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;


/**
 *
 * @author Will
 *
 */

public class Random extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.random() * results.pop().getValue();
    }
}
