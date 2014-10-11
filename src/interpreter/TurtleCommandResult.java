package interpreter;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
/**
 * @author Will Chang 
 */


public class TurtleCommandResult extends SLogoResult {
    
    public TurtleCommandResult(double myValue) {
        super(myValue);
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
