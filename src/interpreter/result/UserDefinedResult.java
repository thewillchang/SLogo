package interpreter.result;

import java.util.List;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

/**
 * Results for User Defined Expression
 * @author Will Chang
 *
 */

public class UserDefinedResult extends SLogoResult {

    /**
     * Constructor
     */
    public UserDefinedResult() {
        super();
    }
    
    public UserDefinedResult(double myValue) {
        super(myValue);
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
    public void setValue(double value) {
        myValue = value;
    }

    @Override
    public double getValue () {
        return myValue;
    }
}
