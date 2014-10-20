package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

public class Quotient extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double numerator = results.pop().getValue();
        double denominator = results.pop().getValue();
        return numerator/denominator;
    }



}
