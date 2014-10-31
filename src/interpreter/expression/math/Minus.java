package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

/**
 * Minus Expression
 * @author Will
 *
 */

public class Minus extends MathExpression{
    @Override
    /**
     * Returns the minus value of the first result. 
     */
    protected double applyMath (Deque<SLogoResult> results) {
       return (-1)*results.pop().getValue();
    }
}
