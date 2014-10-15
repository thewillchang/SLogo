package interpreter.expression;

import java.util.Deque;
import java.util.List;
import interpreter.SLogoResult;
import interpreter.SyntaxResult;

/**
 * 
 * @author Will Chang
 *
 */
public class Constant extends SyntaxExpression {

    private List<SLogoExpression> myParameters;
    private double myConstantValue;
    
    public Constant () {
        
    }
    
    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        
    }

    public void setValue(double value) {
        myConstantValue = value;
    }
    
    @Override
    public SLogoResult evaluate() {
            // TODO Auto-generated method stub
            return new SyntaxResult(myConstantValue);
    }

}