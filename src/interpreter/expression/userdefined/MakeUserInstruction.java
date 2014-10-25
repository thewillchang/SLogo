package interpreter.expression.userdefined;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;
import java.util.Map;

/**
 * 
 * @author Will Chang
 *
 */

public class MakeUserInstruction extends UserDefinedExpression{
    

    @Override
    public SLogoResult evaluate () {
        Map<String, SLogoExpression> myCommands = myLibrary.getUserDefinedCommands();
        SLogoExpression myVarName = myArguments.pop();
        SLogoExpression myAssignment = myArguments.pop();
        myCommands.put(myVarName.evaluate().toString(), myAssignment);
        return myAssignment.evaluate();
    }
    
    @Override
    public void setValue (String value) {
    }


}
