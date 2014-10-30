package interpreter.expression.math;

import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;


/**
 *
 * @author Will
 *
 */
public class Quotient extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double numerator = results.pop().getValue();
        double denominator = results.pop().getValue();
        return numerator / denominator;
    }

}
