package interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;


/**
 * wrapper class for results of interpreting an SLogo command
 * @author Jonathan Tseng and Will Chang
 *
 */
public abstract class SLogoResult {

        protected List<TransitionState> myTransitionStates;
        protected ResourceBundle myProperties;
        protected double myValue;
        
        
        
        public SLogoResult() {
            myTransitionStates = new ArrayList<>();
            //TODO change this
            myValue = 0;
        }
        
        public SLogoResult(double value){
            this();
            myValue = value;
        }
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
	public abstract double getValue();
	
}
