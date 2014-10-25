package interpreter.expression.userdefined;

import model.UserDefinedVariablesModel;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;

public class MakeVariable extends UserDefinedExpression {

    
    //TODO add to set as well as map?...
    @Override
    public SLogoResult evaluate () {
        UserDefinedVariablesModel myVariables = myLibrary.getUserDefinedVariables();
        SLogoExpression myVarName = myArguments.pop();
        SLogoResult myAssignment = myArguments.pop().evaluate();
        myVariables.putVariable(myVarName.evaluate().toString(), myAssignment.getValue());
        return myAssignment;
    }
    
    @Override
    public void setValue (String value) {
    }

}
