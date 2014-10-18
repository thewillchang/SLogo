package interpreter.expression.conditional;

import interpreter.SLogoResult;

/**
 * 
 * @author Will Chang
 *
 */
public class And extends ConditionalExpression {

    public And () {
        super();
        //TODO Refactor... arguments specified in Library? or how?...
        myNumArgs = 2;
    }
    protected boolean hasSatisfiedCondition(SLogoResult argument) {
        return argument.getValue() > 0;
    }


}
