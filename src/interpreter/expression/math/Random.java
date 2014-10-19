package interpreter.expression.math;

import java.util.Deque;
import interpreter.SLogoResult;

/**
 * 
 * @author Will
 *
 */

public class Random extends MathExpression { 

    public Random () {
        super();
        myNumArgs = 1;
        
    }

    @Override
    protected double applyMath (Deque<SLogoResult> results) {
        return Math.random()*results.pop().getValue();
    }
}
