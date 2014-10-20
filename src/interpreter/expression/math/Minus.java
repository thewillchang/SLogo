package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

/**
 * 
 * @author Will
 *
 */

public class Minus extends MathExpression{

    public Minus () {
        super();
        myNumArgs = 1;
    }

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
       return (-1)*results.pop().getValue();
    }
}
