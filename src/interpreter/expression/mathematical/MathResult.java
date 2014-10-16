package interpreter.expression.mathematical;

import java.util.List;

import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
import interpreter.SLogoResult;

<<<<<<< Updated upstream
/**
 * Wrapper for Results of Math operations
 * @author Tanaka Jimha
 *
 */

public class MathResult extends SLogoResult {
	
	private double myValue;
	private TransitionState myState;
	
	public MathResult(double value, TransitionState state){
=======
public class MathResult extends SLogoResult {
	
	private int myValue;
	private TransitionState myState;
	
	public MathResult(int value, TransitionState state){
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	public double getValue() {
=======
	public int getValue() {
>>>>>>> Stashed changes
		// TODO Auto-generated method stub
		return myValue;
	}

}
