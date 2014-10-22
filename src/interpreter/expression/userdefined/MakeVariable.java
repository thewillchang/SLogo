package interpreter.expression.userdefined;

import java.util.Map;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;

public class MakeVariable extends UserDefinedExpression {
    private String myVariableName;
    
    @Override
    public SLogoResult evaluate () {
        Map<String, SLogoExpression> myVariables = myLibrary.getUserDefinedVariables();
    }
    
    @Override
    public void setValue (String value) {
        myVariableName = value;    
    }

}
