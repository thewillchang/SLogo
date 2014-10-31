package interpreter.result;

import java.util.List;
import transitionstate.NullTransitionState;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

public class ErrorResult extends SLogoResult {
    private Exception myException;
    
    public ErrorResult (Exception myException2) {
        myException = myException2;
    }

    @Override
    public Exception getException () {
        return myException;
    }

    @Override
    public List<TransitionState> getTransition () {
        myTransitionStates.add(new NullTransitionState());
        return myTransitionStates;
    }

    @Override
    public double getValue () {
        return 0;
    }

}
