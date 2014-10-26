package interpreter.expression.syntax;

import interpreter.expression.SyntaxExpression;
import interpreter.result.SLogoResult;
import interpreter.result.SyntaxResult;

public class ListEnd extends SyntaxExpression {   

    @Override
    public SLogoResult evaluate () {
        return new SyntaxResult();
    }

}