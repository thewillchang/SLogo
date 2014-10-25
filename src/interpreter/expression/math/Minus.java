package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;
import interpreter.expression.MathExpression;

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
