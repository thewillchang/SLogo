package interpreter.result;

import java.util.List;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

/**
 * 
 * @author Will
 *
 */

public class ControlStructureResult extends SLogoResult{


    public ControlStructureResult() {
        super();
    }
    public ControlStructureResult(double myValue) {
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






