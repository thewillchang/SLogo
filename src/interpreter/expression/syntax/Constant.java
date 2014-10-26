package interpreter.expression.syntax;


import interpreter.SLogoResult;
import interpreter.SyntaxResult;
import interpreter.expression.SyntaxExpression;

/**
 * 
 * @author Will Chang
 *
 */
public class Constant extends SyntaxExpression {
    
    private Double myValue;
    
    public Constant () {
        this(0);
    }

    public Constant (double value) {
        myValue = value;
    }
    
    @Override
    public void setValue(String value) {
        myValue = Double.parseDouble(value);
    }
    
    @Override
    public String getValue() {
        return myValue.toString();
    }
    
    @Override
    public SLogoResult evaluate() {
            return new SyntaxResult(myValue);
    }



}
