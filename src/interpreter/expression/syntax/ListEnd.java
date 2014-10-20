package interpreter.expression.syntax;

import interpreter.SLogoResult;
import interpreter.SyntaxResult;
import interpreter.expression.SyntaxExpression;

public class ListEnd extends SyntaxExpression {   

    @Override
    public SLogoResult evaluate () {
        return new SyntaxResult();
    }

    @Override
    public void setValue (String value) {        
    }
}