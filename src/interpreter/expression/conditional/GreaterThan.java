package interpreter.expression.conditional;

import interpreter.expression.ConditionalExpression;
import interpreter.result.SLogoResult;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implements the < operation on given operands
 * @authors Tanaka Jimha and Will Chang
 */

public class GreaterThan extends ConditionalExpression {

    @Override
    protected boolean hasSatisfiedCondition (SLogoResult argument) {
        if (valuesToCompare.isEmpty()) {
            valuesToCompare.push(argument.getValue());
            return true;
        }
        return valuesToCompare.peek() > argument.getValue();
    }
}
