package interpreter.expression.conditional;

import interpreter.SLogoResult;

/**
 * 
 * @author Will Chang
 *
 */
public class And extends ConditionalExpression {
    protected boolean hasSatisfiedCondition(SLogoResult argument) {
        return argument.getValue() > 0;
    }
}
