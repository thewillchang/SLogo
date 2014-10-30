package interpreter.expression.conditional;

import interpreter.expression.ConditionalExpression;
import interpreter.result.SLogoResult;


/**
 *
 * @author Will Chang
 *
 */
public class And extends ConditionalExpression {
    @Override
    protected boolean hasSatisfiedCondition (SLogoResult argument) {
        return argument.getValue() > 0;
    }
}
