package interpreter.expression.userdefined;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import model.UserDefinedVariablesModel;
import transitionstate.TransitionState;
import interpreter.ControlStructureResult;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;

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

        UserDefinedVariablesModel myVariables = myLibrary.getUserDefinedVariables();
        SLogoResult myMaxReps = myArguments.pop().evaluate();
        Integer maxReps = (int) myMaxReps.getValue();
        results.add(myMaxReps);
        
        SLogoExpression expressionList = myArguments.pop();
        
        for(Integer currentRep = 1 ; currentRep <= maxReps; currentRep++) {
            myVariables.putVariable(repCount, currentRep);
            results.add(expressionList.evaluate());
        }
        
        for(SLogoResult result : results) {
            transitionStates.addAll(result.getTransition());    
        }
        myResult.setValue(results.getLast().getValue());
        myVariables.remove(repCount);
        return myResult;
    }
    
    /* Implementation where the Model stores an expression instead of a Double...
      @Override
    public SLogoResult evaluate () {
        SLogoResult myResult = new ControlStructureResult();
        List<TransitionState> transitionStates = myResult.getTransition();
        Deque<SLogoResult> results = new ArrayDeque<>();

        //TODO Refactor naming...
        UserDefinedVariablesModel myVariables = myLibrary.getUserDefinedVariables();
        SLogoResult myMaxReps = myArguments.pop().evaluate();
        Integer maxReps = (int) myMaxReps.getValue();
        results.add(myMaxReps);

        //Refactor...?
        Constant myCurrentRepCount = new Constant();
        myVariables.putVariable(repCount, myCurrentRepCount);
        
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
     */
    
    //This doesnt use it.
    @Override
    public void setValue(String value) {
        
    }

}