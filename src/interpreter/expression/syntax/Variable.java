package interpreter.expression.syntax;

import java.util.Map;
import interpreter.SLogoResult;
import interpreter.SyntaxResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SyntaxExpression;

public class Variable extends SyntaxExpression {
    private String myValue;
    
    @Override
    public SLogoResult evaluate () {
        
        //TODO refactor evaluate methods for all expression to use List, so that
        //arguments are not destroyed when evaluating...
        //Change up the method calls to containsKey...
        
        //TODO check for errors... should it throw an error if a string is returned
        //when the variable expression should be defined?
        
        //TODO maybe have a set of all defined variables, then check if its in the set,
        //if its in the set, check if it's in the map... then do more logic...
        Map<String, SLogoExpression> myUserDefinedVariables = myLibrary.getUserDefinedVariables();
        if(myUserDefinedVariables.containsKey(myValue)) {
            return myUserDefinedVariables.get(myValue).evaluate();
        }
        return new SyntaxResult(myValue);
    }
    
    @Override
    public void setValue (String value) {
        myValue = value;
    }

}
