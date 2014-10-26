package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

/**
 * 
 * @author Will
 *
 */

public class Random extends MathExpression { 

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.random()*results.pop().getValue();
    }
}
