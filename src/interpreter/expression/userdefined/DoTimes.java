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
public class DoTimes extends UserDefinedExpression {

    @Override
    public SLogoResult evaluate () {
        SLogoResult myResult = new ControlStructureResult();
        List<TransitionState> transitionStates = myResult.getTransition();
        Deque<SLogoResult> results = new ArrayDeque<>();
        UserDefinedVariablesModel myVariables = myLibrary.getUserDefinedVariables();

        List<SLogoExpression> argumentCopy = new ArrayList<>(myArguments);
        Deque<SLogoExpression> myParams =
                ((SyntaxResult) argumentCopy.get(0).evaluate()).getGroupedExpressions();
        String myLimitVariable = myParams.pop().getValue();

        Integer limit = (int) myParams.pop().evaluate().getValue();

        SLogoExpression expressionList = argumentCopy.get(1);

        for (Integer currentRep = 1; currentRep <= limit; currentRep++) {
            myVariables.putVariable(myLimitVariable, currentRep);
            results.add(expressionList.evaluate());
        }

        for (SLogoResult result : results) {
            transitionStates.addAll(result.getTransition());
        }
        myResult.setValue(results.getLast().getValue());
        myVariables.remove(myLimitVariable);
        return myResult;
    }

}
