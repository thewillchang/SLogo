package interpreter.expression.userdefined;

import java.util.Map;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;

public class MakeVariable extends UserDefinedExpression {
    
    @Override
    public SLogoResult evaluate () {
        Map<String, SLogoExpression> myVariables = myLibrary.getUserDefinedVariables();
        SLogoExpression myVarName = myArguments.pop();
        SLogoExpression myAssignment = myArguments.pop();
        myVariables.put(myVarName.evaluate().toString(), myAssignment);
        return myAssignment.evaluate();
    }
    
    @Override
    public void setValue (String value) {
    }

}
