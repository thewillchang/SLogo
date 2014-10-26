package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

/**
 * 
 * @author Will
 *
 */

public class Minus extends MathExpression{

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
       return (-1)*results.pop().getValue();
    }
}
