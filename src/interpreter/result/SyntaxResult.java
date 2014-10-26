package interpreter.result;

import interpreter.expression.SLogoExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import transitionstate.NullTransitionState;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

public class SyntaxResult extends SLogoResult {
    private String myLabel; 
    private Deque<SLogoExpression> myGroupedExpressions;

    public SyntaxResult () {
        this(0);
    }

    public SyntaxResult (String str) {
        this(0);
        myLabel = str;

    }

    public SyntaxResult (double value) {
        super(value);
        myTransitionStates.add(new NullTransitionState());
        myGroupedExpressions = new ArrayDeque<>(); 
    }

    @Override
    public SLogoParsingException getException () {
        return null;
    }

    public Deque<SLogoExpression> getGroupedExpressions () {
        return myGroupedExpressions;
    }

    public void setGroupedExpressions (Deque<SLogoExpression> groupedExpressions) {
        myGroupedExpressions = groupedExpressions;   
    }

    @Override
    public List<TransitionState> getTransition () {
        myTransitionStates.add(new NullTransitionState());
        return myTransitionStates;
    }

    @Override
    public double getValue () {
        return myValue;
    }

    @Override
    public String toString () {
        return myLabel;
    }

}
