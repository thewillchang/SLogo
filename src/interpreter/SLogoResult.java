package interpreter;

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
	protected String myLabel;
	protected double myValue;
	private boolean myHasError;
	
	/**
	 * Constructors
	 */
	public SLogoResult() {
		this(0);
	}
	
	public SLogoResult(double value) {
		myHasError = false;
		myTransitionStates = new ArrayList<>();
		myValue = value;
	}

	/**
	 * Returns an exception if found when evaluating the SLogoExpression
	 * 
	 * @return the SLogoParsingException
	 */
	public abstract SLogoParsingException getException();

	/**
	 * Returns a list of transition states from evaluating the SLogoExpression
	 * 
	 * @return List of Transition states
	 */
	public abstract List<TransitionState> getTransition();

	/**
	 * Returns the integer output from evaluating the SLogoExpression
	 * 
	 * @return the value of the result
	 */
	public abstract double getValue();

	
	/**
	 * Checks if SLogoResult has an error
	 * @return
	 */
	public boolean getHasError() {
		return myHasError;
	}

	/**
	 * Sets the value of the result
	 * @param value
	 */
	public void setValue(double value) {
		myValue = value;
	}

	/**
	 * Sets the label of the Results, the name of its parent Expression
	 * @param str the label
	 */
	public void setLabel(String str) {
	    myLabel = str;
	}
	
	/**
	 * Returns the Label as its string
	 */
	public String toString() {
	    return myLabel;
	}
}
