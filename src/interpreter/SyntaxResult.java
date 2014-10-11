package interpreter;

import java.util.List;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

public class SyntaxResult extends SLogoResult {

    public SyntaxResult (double value) {
        super(value);
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
    public double getValue () {
        // TODO Auto-generated method stub
        return 0;
    }

}
