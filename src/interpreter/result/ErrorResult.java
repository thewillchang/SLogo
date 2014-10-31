package interpreter.result;

import java.util.List;

import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

public class ErrorResult extends SLogoResult {

	private SLogoParsingException mySLogoParsingException;

	public ErrorResult(SLogoParsingException slpe) {
		super(slpe);
		mySLogoParsingException = slpe;
	}

	@Override
	public SLogoParsingException getException() {
		return mySLogoParsingException;
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
