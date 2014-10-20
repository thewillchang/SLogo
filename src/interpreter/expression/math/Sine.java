package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

public class Sine extends MathExpression {

    public Sine () {
        super();
        myNumArgs = 1;
    }

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.sin(results.pop().getValue());
    }

}
