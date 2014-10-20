package interpreter;

import java.util.List;
import transitionstate.NullTransitionState;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

public class SyntaxResult extends SLogoResult {

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

}
