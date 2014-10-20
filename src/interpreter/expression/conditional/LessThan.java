package interpreter.expression.conditional;

import interpreter.SLogoResult;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implements the < operation on given operands
 * @author Tanaka Jimha and Will Chang
 */

public class LessThan extends ConditionalExpression {

    private Deque<Double> valuesToCompare;

    public LessThan () {
        super();
        myNumArgs = 2;
        valuesToCompare = new ArrayDeque<>();
    }

    @Override
    protected boolean hasSatisfiedCondition (SLogoResult argument) {
        if (valuesToCompare.isEmpty()) {
            valuesToCompare.push(argument.getValue());
            return true;
        }
        return valuesToCompare.peek() < argument.getValue();
    }
}
