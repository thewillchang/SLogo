package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

/**
 * Remainder Expression
 * @author Will
 *
 */
public class Remainder extends MathExpression {
    @Override
    /**
     * Returns the remainder when dividing value of first
     * result by value of second result
     */
    protected double applyMath (Deque<SLogoResult> results) {
        double numerator = results.pop().getValue();
        double denominator = results.pop().getValue();
        return numerator%denominator;
    }

}
