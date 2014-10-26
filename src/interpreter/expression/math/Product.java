package interpreter.expression.math;

import java.util.Deque;
import interpreter.expression.MathExpression;
import interpreter.result.SLogoResult;

public class Product extends MathExpression{

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double value = 1;
        while(!results.isEmpty()) {
            value *= results.pop().getValue();
        }
        return value;
    }
}
