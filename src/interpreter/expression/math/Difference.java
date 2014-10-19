package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

/**
 * 
 * @author Will Chang
 *
 */

public class Difference extends MathExpression {

    public Difference () {
        super();
        myNumArgs = 2;
    }
    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return results.pop().getValue() - results.pop().getValue();
    }
}
