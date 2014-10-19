package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

public class Cosine extends MathExpression {

    public Cosine () {
        super();
        myNumArgs = 1;
    }

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.cos(results.pop().getValue());
    }
}
