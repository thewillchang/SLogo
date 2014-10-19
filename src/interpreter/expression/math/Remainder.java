package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

/**
 * 
 * @author Will
 *
 */
public class Remainder extends MathExpression {


    public Remainder () {
        super();
        myNumArgs = 2;
    }

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double numerator = results.pop().getValue();
        double denominator = results.pop().getValue();
        return numerator%denominator;
    }

}
