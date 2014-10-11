package interpreter.expression.conditional;

import java.util.List;

import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
import interpreter.SLogoResult;

public class ConditionalResult extends SLogoResult {
	
	private int myValue;
	private TransitionState myState;
	
	public ConditionalResult(int value, TransitionState state){
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
	public double getValue() {

		return this.myValue;
	}

}
