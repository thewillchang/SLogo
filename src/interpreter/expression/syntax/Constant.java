package interpreter.expression.syntax;

import java.util.Deque;
import java.util.List;
import interpreter.SLogoResult;
import interpreter.SyntaxResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SyntaxExpression;

/**
 * 
 * @author Will Chang
 *
 */
public class Constant extends SyntaxExpression {
    
    private double myConstantValue;
    
    public Constant () {
        
    }

    @Override
    public void setValue(String value) {
        myConstantValue = Double.parseDouble(value);
    }
    
    @Override
    public SLogoResult evaluate() {
            return new SyntaxResult(myConstantValue);
    }

}
