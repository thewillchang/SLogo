package interpreter.expression.conditional;

import interpreter.SLogoResult;

/**
 * 
 * @author Will Chang
 *
 */
public class Not extends ConditionalExpression {

    public Not () {
        super();
        //TODO Refactor... arguments specified in Library? or how?...
        myNumArgs = 1;
    }
    
    @Override
    protected boolean hasSatisfiedCondition (SLogoResult argument) {
        return (argument.getValue() == 0)? true : false;
    }

}
