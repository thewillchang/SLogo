package interpreter.result;

import java.util.List;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;


/**
 * @author Will Chang
 */

public class TurtleCommandResult extends SLogoResult {

    public TurtleCommandResult () {
        super(0);
    }

    public TurtleCommandResult (double myValue) {
        super(myValue);
    }

    @Override
    public SLogoParsingException getException () {
        return null;
    }

    @Override
    public void setValue (double value) {
        myValue = value;
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
