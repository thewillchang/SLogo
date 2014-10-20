package interpreter.expression.conditional;

import interpreter.SLogoResult;

/**
 * 
 * @author Will Chang
 *
 */
public class Not extends ConditionalExpression {

    @Override
    protected boolean hasSatisfiedCondition (SLogoResult argument) {
        return (argument.getValue() == 0)? true : false;
    }

}
