package interpreter.expression.userdefined;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;
import interpreter.result.ControlStructureResult;
import interpreter.result.SLogoResult;
import interpreter.result.SyntaxResult;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import model.UserDefinedVariablesModel;
import transitionstate.TransitionState;
/**
 * 
 * @author Will Chang
 *
 */
public class For extends UserDefinedExpression {
    @Override
    public SLogoResult evaluate () {
        SLogoResult myResult = new ControlStructureResult();
        List<TransitionState> transitionStates = myResult.getTransition();
        Deque<SLogoResult> results = new ArrayDeque<>();
        UserDefinedVariablesModel myVariables = myLibrary.getUserDefinedVariables();
        //TODO fix this 
        List<SLogoExpression> argumentCopy = new ArrayList<>(myArguments);
        Deque<SLogoExpression> myParams = ((SyntaxResult) argumentCopy.get(0).evaluate()).getGroupedExpressions();
        //TODO Add checks/exception handling
        String myVariable = myParams.pop().getValue();
        Integer start =  (int) myParams.pop().evaluate().getValue();
        Integer end = (int) myParams.pop().evaluate().getValue() ;
        Integer increment = (int) myParams.pop().evaluate().getValue();
        SLogoExpression expressionList = argumentCopy.get(1);
        for(Integer currentRep = start ; currentRep <= end; currentRep+=increment) {
            myVariables.putVariable(myVariable, currentRep);
            results.add(expressionList.evaluate());
        }
        for(SLogoResult result : results) {
            transitionStates.addAll(result.getTransition());    
        }
        myResult.setValue(results.getLast().getValue());
        myVariables.remove(myVariable);
        return myResult;
    }
}