package interpreter.expression.math;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;

/**
 * superclass of SLogoExpressions for Math expressions
 * @author Will Chang
 *
 */
public abstract class MathExpression implements SLogoExpression {

    protected Deque<SLogoExpression> myArguments;
    protected int myNumArgs;

    public MathExpression() {
        //specifyNumberAndLoad(args,myNumArgs);
        myArguments = new ArrayDeque<>();
        //myNumArgs = 2;
    }

    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        for(int i = 0 ; i < myNumArgs ; i++) {
            myArguments.add(args.pop());                    
        }
    }

    /* public void setNumArgs(double numArgs);*/
    
    //TODO Change deque in the evaluate/load phases... to list...
    @Override
    public SLogoResult evaluate() {
        Deque<SLogoResult> results = new ArrayDeque<>();
        while(!myArguments.isEmpty()) {
            results.add(myArguments.pop().evaluate());
        }
        return applyOperatorAndMerge(results);
    }

    protected SLogoResult applyOperatorAndMerge (Deque<SLogoResult> results) {
        SLogoResult myResult = new MathResult();
        myResult.setValue(applyMath(results)); 
        mergePreviousResults(results, myResult);
        return myResult;
    }

    protected abstract double applyMath (Deque<SLogoResult> results);

    //Using deque, dont have to reference the indices...
    protected void mergePreviousResults (Deque<SLogoResult> results, SLogoResult myResult) {
        List<TransitionState> transitionStates = myResult.getTransition();
        for(SLogoResult result : results) {
            transitionStates.addAll(result.getTransition());
        }
        //Add a nulltransition? at the end...?
        //transitionStates.add(new NullTransitionState());
    }
}