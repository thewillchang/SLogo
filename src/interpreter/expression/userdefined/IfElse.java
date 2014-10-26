package interpreter.expression.userdefined;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;
import interpreter.result.ControlStructureResult;
import interpreter.result.SLogoResult;

public class IfElse extends UserDefinedExpression {

    @Override
    public SLogoResult evaluate () {
        Deque<SLogoResult> myResults = new ArrayDeque<>();
        List<SLogoExpression> copyArguments = new ArrayList<>(myArguments);
        SLogoResult condition = copyArguments.get(0).evaluate();
        myResults.add(condition);
        SLogoExpression commands =  copyArguments.get(1);
        if (condition.getValue() > 0) {
           myResults.add(commands.evaluate());
        }
        else {
            commands = copyArguments.get(2);
            myResults.add(commands.evaluate());
        }
        return merge(myResults);
        
    }


    private SLogoResult merge (Deque<SLogoResult> myResults) {
        SLogoResult myResult = new ControlStructureResult();
        List<TransitionState> transitionStates = myResult.getTransition();
        for(SLogoResult result : myResults) {
            transitionStates.addAll(result.getTransition());
            myResult.setValue(result.getValue());
        }
        return myResult;
    }


    
}
