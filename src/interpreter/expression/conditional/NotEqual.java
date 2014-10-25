package interpreter.expression.conditional;

import interpreter.SLogoResult;
import interpreter.expression.ConditionalExpression;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author Will Chang
 *
 */

public class NotEqual extends ConditionalExpression {
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
