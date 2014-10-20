package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

public class Sine extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.sin(results.pop().getValue());
    }

}
