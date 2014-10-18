package interpreter.expression.conditional;

import interpreter.SLogoResult;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author Will Chang
 *
 */

public class NotEqual extends ConditionalExpression {
    
    
    private Deque<Double> valuesToCompare;
    
    public NotEqual () {
        super();
        //TODO Refactor... arguments specified in Library? or how?...
        myNumArgs = 2;
        valuesToCompare = new ArrayDeque<>();
    }
    
    
    //TODO Refactor...
    @Override
    protected boolean hasSatisfiedCondition (SLogoResult argument) {
        if (valuesToCompare.isEmpty()) {
            valuesToCompare.push(argument.getValue());
            return true;
        }
        return valuesToCompare.peek() != argument.getValue();
    }


}
