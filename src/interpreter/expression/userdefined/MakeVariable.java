package interpreter.expression.userdefined;

import java.util.ArrayList;
import java.util.List;
import model.UserDefinedVariablesModel;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;

public class MakeVariable extends UserDefinedExpression {

    
    //TODO add to set as well as map?...
    @Override
    public SLogoResult evaluate () {
        UserDefinedVariablesModel myVariables = myLibrary.getUserDefinedVariables();
        List<SLogoExpression> copyArguments = new ArrayList<>(myArguments);
        SLogoExpression myVarName = copyArguments.get(0);
        SLogoResult myAssignment = copyArguments.get(1).evaluate();
        myVariables.putVariable(myVarName.evaluate().toString(), myAssignment.getValue());
        return myAssignment;
    }
    
    @Override
    public void setValue (String value) {
    }

}
