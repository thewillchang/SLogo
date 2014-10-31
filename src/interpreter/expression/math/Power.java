// This entire file is part of my masterpiece.
// William Chang
package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
/**
 * Power Expression
 * @author Will
 *
 */
public class Power extends MathExpression {
    @Override
    /**
     * Takes the value of the first result to the power of 
     * the value of the second result
     */
    protected double applyMath (Deque<SLogoResult> results) {
        double base = results.pop().getValue();
        double power = results.pop().getValue();
        return Math.pow(base, power);
    }
}
