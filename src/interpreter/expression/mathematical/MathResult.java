package interpreter.expression.mathematical;

import java.util.List;

import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
import interpreter.SLogoResult;

public class MathResult extends SLogoResult {
	
	private int myValue;
	private TransitionState myState;
	
	public MathResult(int value, TransitionState state){
		this.myValue = value;
		this.myState = state;
	}

	@Override
	public SLogoParsingException getException() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransitionState> getTransition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return myValue;
	}

}
