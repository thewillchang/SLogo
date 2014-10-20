package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

public class Power extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double base = results.pop().getValue();
        double power = results.pop().getValue();
        return Math.pow(base, power);
    }
}
