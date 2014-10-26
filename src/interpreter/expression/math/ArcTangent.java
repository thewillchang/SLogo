package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;
import interpreter.expression.MathExpression;

/**
 * 
 * @author Will Chang
 *
 */

public class ArcTangent extends MathExpression {
    
    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.toDegrees(Math.atan(results.pop().getValue()));
    }
    

}
