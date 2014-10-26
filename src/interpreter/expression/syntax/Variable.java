package interpreter.expression.syntax;
import interpreter.expression.SyntaxExpression;
import interpreter.result.SLogoResult;
import interpreter.result.SyntaxResult;
import model.UserDefinedVariablesModel;
public class Variable extends SyntaxExpression {
    
    @Override
    public SLogoResult evaluate () {
        
        //TODO refactor evaluate methods for all expression to use List, so that
        //arguments are not destroyed when evaluating...
        //Change up the method calls to containsKey...
        
        //TODO check for errors... should it throw an error if a string is returned
        //when the variable expression should be defined?
        
        //TODO maybe have a set of all defined variables, then check if its in the set,
        //if its in the set, check if it's in the map... then do more logic...
        UserDefinedVariablesModel myUserDefinedVariables = myLibrary.getUserDefinedVariables();
        SLogoResult myResult = new SyntaxResult(myValue);
        if(myUserDefinedVariables.containsVariable(myValue)) {
            myResult.setValue(myUserDefinedVariables.getVariable(myValue));
        }
        return myResult;
    }
    
}