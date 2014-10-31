// This entire file is part of my masterpiece.
// William Chang
package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
/**
 * Sum Expression
 * @author Will Chang
 *
 */
public class Sum extends MathExpression {
    

    @Override
    /**
     * Sums all values of all results
     */
    protected double applyMath (Deque<SLogoResult> results) {
        double sum = 0;
        while(!results.isEmpty()) {
            sum += results.pop().getValue();
        }
        return sum;
    }
}