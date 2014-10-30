package interpreter.expression.conditional;

import interpreter.expression.ConditionalExpression;
import interpreter.result.SLogoResult;


/**
 * Implements the < operation on given operands
 *
 * @author Tanaka Jimha and Will Chang
 */

public class LessThan extends ConditionalExpression {

    @Override
    protected boolean hasSatisfiedCondition (SLogoResult argument) {
        if (valuesToCompare.isEmpty()) {
            valuesToCompare.push(argument.getValue());
            return true;
        }
        return valuesToCompare.peek() < argument.getValue();
    }
}
