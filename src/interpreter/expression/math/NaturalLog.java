package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

public class NaturalLog extends MathExpression {

    public NaturalLog () {
        super();
        myNumArgs = 1;
    }

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.log(results.pop().getValue());
    }
}
