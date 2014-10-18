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
    @Override
    public SLogoParsingException getException () {
        return null;
    }

    @Override
    public List<TransitionState> getTransition () {
        return myTransitionStates;
    }

    @Override
    public double getValue () {
        return myValue;
    }

}
