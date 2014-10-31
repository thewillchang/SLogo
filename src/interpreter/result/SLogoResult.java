package interpreter.result;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

/**
 * wrapper class for results of interpreting an SLogo command
 * 
 * @author Jonathan Tseng and Will Chang
 *
 */
public abstract class SLogoResult {

	protected List<TransitionState> myTransitionStates;
	protected ResourceBundle myProperties;
	protected double myValue;
	protected String myLabel;
	private boolean myHasError;

	public SLogoResult() {
		this(0);
	}

	public SLogoResult(double value) {
		myHasError = false;
		myTransitionStates = new ArrayList<>();
		myValue = value;
	}

	/**
	 * returns an exception if found when evaluating the SLogoExpression
	 * 
	 * @return
	 */
	public abstract Exception getException();

	/**
	 * returns a list of transition states from evaluating the SLogoExpression
	 * 
	 * @return
	 */
	public abstract List<TransitionState> getTransition();

	/**
	 * returns the integer output from evaluating the SLogoExpression
	 * 
	 * @return
	 */
	public abstract double getValue();

	public boolean getHasError() {
		return myHasError;
	}

	public void setValue(double value) {
		myValue = value;
	}

	public void setLabel(String str) {
	    myLabel = str;
	}
	
	public String toString() {
	    return myLabel;
	}
}
