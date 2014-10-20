package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

/**
 * 
 * @author Will
 *
 */

public class Tangent extends MathExpression {

    public Tangent () {
        super();
        myNumArgs = 1;
    }

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.tan(results.pop().getValue());
    }
}
