package interpreter.expression.userdefined;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;
import interpreter.result.SLogoResult;
import java.util.ArrayList;
import java.util.List;
import model.UserDefinedVariablesModel;
/**
 * 
 * @author Will
 *
 */

public class MakeVariable extends UserDefinedExpression {
    

    @Override
    public SLogoResult evaluate () {
        UserDefinedVariablesModel myVariables = myLibrary.getUserDefinedVariables();
        List<SLogoExpression> copyArguments = new ArrayList<>(myArguments);
        SLogoExpression myVarName = copyArguments.get(0);
        SLogoResult myAssignment = copyArguments.get(1).evaluate();
        myVariables.putVariable(myVarName.evaluate().toString(), myAssignment.getValue());
        return myAssignment;
    }
    
}