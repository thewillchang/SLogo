package interpreter.expression.syntax;
import interpreter.expression.SyntaxExpression;
import interpreter.result.SLogoResult;
import interpreter.result.SyntaxResult;
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