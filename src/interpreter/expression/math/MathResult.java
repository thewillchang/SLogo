package interpreter.expression.math;

import java.util.List;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
import interpreter.result.SLogoResult;

/**
 * Wrapper for Results of Math operations
 * @author Will Chang and Tanaka Jimha
 *
 */

public class MathResult extends SLogoResult {

    public MathResult() {
        super();
    }
    
    public MathResult(double value) {
        super(value);   
    }

    @Override
    public SLogoParsingException getException() {
        return null;
    }

    @Override
    public List<TransitionState> getTransition() {
        return myTransitionStates;
    }

    @Override
    public double getValue() {
        return myValue;
    }

}
