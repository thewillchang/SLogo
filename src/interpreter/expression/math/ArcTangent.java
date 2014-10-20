package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

/**
 * 
 * @author Will Chang
 *
 */

public class ArcTangent extends MathExpression {

    public ArcTangent () {
        super();
        myNumArgs = 1;
    }
    
    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.atan(results.pop().getValue());
    }
    

}
