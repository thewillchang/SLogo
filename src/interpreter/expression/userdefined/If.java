package interpreter.expression.userdefined;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import model.MainModel;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
import interpreter.CommandReferenceLibrary;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;
import interpreter.expression.syntax.ListEnd;
import interpreter.expression.syntax.ListStart;
import interpreter.result.ControlStructureResult;
import interpreter.result.SLogoResult;

public class If extends UserDefinedExpression {



    @Override
    public SLogoResult evaluate () {
        Deque<SLogoResult> myResults = new ArrayDeque<>();
        List<SLogoExpression> copyArguments = new ArrayList<>(myArguments);
        SLogoResult condition = copyArguments.get(0).evaluate();

        myResults.add(condition);
        if (condition.getValue() > 0) {
            myResults.add(copyArguments.get(1).evaluate());
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