package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

/**
 * Quotient Expression
 * @author Will
 *
 */
public class Quotient extends MathExpression {
    @Override
    /**
     * Returns the quotient from dividing value of first result from
     * value of second result.
     */
    protected double applyMath (Deque<SLogoResult> results) {
        double numerator = results.pop().getValue();
        double denominator = results.pop().getValue();
        return numerator/denominator;
    }



}
