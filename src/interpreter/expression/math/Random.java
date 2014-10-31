package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

/**
 * Random Expression
 * @author Will
 *
 */

public class Random extends MathExpression { 
    @Override
    /**
     * Returns a random number given the upper bound from the value
     * of the first result.
     */
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.random()*results.pop().getValue();
    }
}
