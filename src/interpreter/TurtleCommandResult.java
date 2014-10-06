package interpreter;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

public class TurtleCommandResult extends SLogoResult {
    private ResourceBundle myProperties;
    
    public TurtleCommandResult(int value) {
        super();
        
        
        
    }
    @Override
    public SLogoParsingException getException () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TransitionState> getTransition () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getValue () {
        // TODO Auto-generated method stub
        return 0;
    }

}
