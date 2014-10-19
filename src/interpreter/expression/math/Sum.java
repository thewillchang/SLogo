package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

public class Sum extends MathExpression {

    public Sum () {
        super();
        myNumArgs = 2;
    }

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double sum = 0;
        while(!results.isEmpty()) {
            sum += results.pop().getValue();
        }
        return sum;
    }
}