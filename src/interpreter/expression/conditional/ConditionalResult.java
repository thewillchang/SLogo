package interpreter.expression.conditional;

import interpreter.result.SLogoResult;
import java.util.List;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;


/**
 *
 * @author Will
 *
 */

public class ConditionalResult extends SLogoResult {

    public ConditionalResult () {
        super();
    }

    public ConditionalResult (double value) {
        super(value);
    }

    @Override
    public SLogoParsingException getException () {
        // TODO Auto-generated method stub
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
