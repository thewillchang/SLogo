package interpreter;

import java.util.List;
import transitionstate.NullTransitionState;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

public class SyntaxResult extends SLogoResult {
    private String myLabel; 
    
    public SyntaxResult (String str) {
        super();
        myLabel = str;
        myTransitionStates.add(new NullTransitionState());
    }
    
    public SyntaxResult (double value) {
        super(value);
        myTransitionStates.add(new NullTransitionState());
    }
    public SyntaxResult () {
        // TODO Auto-generated constructor stub
    }
    @Override
    public SLogoParsingException getException () {
        return null;
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
