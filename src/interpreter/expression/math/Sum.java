package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;
import interpreter.expression.MathExpression;

public class Sum extends MathExpression {
    
    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        double sum = 0;
        while(!results.isEmpty()) {
            sum += results.pop().getValue();
        }
        return sum;
    }
}