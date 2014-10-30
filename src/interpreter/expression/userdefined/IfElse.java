package interpreter.expression.userdefined;

import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;
import interpreter.result.ControlStructureResult;
import interpreter.result.SLogoResult;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;


public class IfElse extends UserDefinedExpression {
    @Override
    public SLogoResult evaluate () {
        Deque<SLogoResult> myResults = new ArrayDeque<>();
        SLogoResult condition = myArguments.pop().evaluate();
        myResults.add(condition);
        SLogoExpression commands = myArguments.pop();
        if (condition.getValue() > 0) {
            myResults.add(commands.evaluate());
        }
        else {
            commands = myArguments.pop();
            myResults.add(commands.evaluate());
        }
        return merge(myResults);

    }

    private SLogoResult merge (Deque<SLogoResult> myResults) {
        SLogoResult myResult = new ControlStructureResult();
        List<TransitionState> transitionStates = myResult.getTransition();
        for (SLogoResult result : myResults) {
            transitionStates.addAll(result.getTransition());
            myResult.setValue(result.getValue());
        }
        return myResult;
    }

}
