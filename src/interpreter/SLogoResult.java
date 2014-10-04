package interpreter;

import java.util.List;

import transitionstate.TransitionState;
import exceptions.SLogoParsingException;


/**
 * wrapper class for results of interpreting an SLogo command
 * @author Jonathan Tseng
 *
 */
public abstract class SLogoResult {

	/**
	 * returns an exception if found when evaluating the SLogoExpression
	 * @return
	 */
	public abstract SLogoParsingException getException();
	
	/**
	 * returns a list of transition states from evaluating the SLogoExpression
	 * @return
	 */
	public abstract List<TransitionState> getTransition();

	/**
	 * returns the integer output from evaluating the SLogoExpression
	 * @return
	 */
	public abstract int getValue();
	
}
