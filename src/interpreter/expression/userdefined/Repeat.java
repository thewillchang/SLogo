package interpreter.expression.userdefined;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
import interpreter.ControlStructureResult;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;
import interpreter.expression.syntax.Constant;
import interpreter.expression.syntax.ListEnd;
import interpreter.expression.syntax.ListStart;

/**
 * 
 * @author Will
 *
 */

public class Repeat extends UserDefinedExpression {
    //private SLogoExpression myMaxRep;
    private final String repCount = ":repcount";

    @Override
    public SLogoResult evaluate () {
        SLogoResult myResult = new ControlStructureResult();
        List<TransitionState> transitionStates = myResult.getTransition();
        Deque<SLogoResult> results = new ArrayDeque<>();

        //TODO Refactor naming...
        Map<String, SLogoExpression> myVariables = myLibrary.getUserDefinedVariables();
        SLogoResult myMaxReps = myArguments.pop().evaluate();
        Integer maxReps = (int) myMaxReps.getValue();
        results.add(myMaxReps);

        //Refactor...?
        Constant myCurrentRepCount = new Constant();
        myVariables.put(repCount, myCurrentRepCount);
        
        SLogoExpression expressionList = myArguments.pop();
        
        for(Integer currentRep = 1 ; currentRep <= maxReps; currentRep++) {
            myCurrentRepCount.setValue(currentRep.toString());
            results.add(expressionList.evaluate());
        }
        for(SLogoResult result : results) {
            transitionStates.addAll(result.getTransition());    
        }
        myResult.setValue(results.getLast().getValue());
        myVariables.remove(repCount);
        return myResult;
    }
    
    //This doesnt use it.
    @Override
    public void setValue(String value) {
        
    }

}