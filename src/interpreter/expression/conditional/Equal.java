package interpreter.expression.conditional;

import interpreter.expression.ConditionalExpression;
import interpreter.result.SLogoResult;


/**
 * 
 * @author Will Chang
 *
 */

public class Equal extends ConditionalExpression { 
    @Override
    protected boolean hasSatisfiedCondition (SLogoResult argument) {
        if (valuesToCompare.isEmpty()) {
            valuesToCompare.push(argument.getValue());
            return true;
        }
        return valuesToCompare.peek() == argument.getValue();
    }
}
