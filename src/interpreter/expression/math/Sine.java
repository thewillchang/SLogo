package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

public class Sine extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.sin(results.pop().getValue());
    }

}
