package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;
import interpreter.expression.MathExpression;

public class NaturalLog extends MathExpression {

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.log(results.pop().getValue());
    }
}
