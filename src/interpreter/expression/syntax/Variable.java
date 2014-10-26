package interpreter.expression.syntax;
import interpreter.expression.SyntaxExpression;
import interpreter.result.SLogoResult;
import interpreter.result.SyntaxResult;
import model.UserDefinedVariablesModel;

/**
 * 
 * @author Will Chang
 *
 */
public class Variable extends SyntaxExpression {
    
    @Override
    public SLogoResult evaluate () {
       
        UserDefinedVariablesModel myUserDefinedVariables = myLibrary.getUserDefinedVariables();
        SLogoResult myResult = new SyntaxResult(myValue);
        if(myUserDefinedVariables.containsVariable(myValue)) {
            myResult.setValue(myUserDefinedVariables.getVariable(myValue));
        }
        return myResult;
    }
    
}