package interpreter;

import transitionstate.TransitionState;

public abstract class SLogoResult {

	boolean myHasError;
	String myError;
	
	public abstract TransitionState getTransition();

	public abstract int getValue();
	
}
