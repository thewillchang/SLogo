package interpreter.expression.query;

import java.util.List;

import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
import interpreter.SLogoResult;

/**
 * Wrapper for Results of Query Expressions
 * @author Abhishek B
 *
 */
public class QueryResult extends SLogoResult {

	public QueryResult() {
		super();
	}
	
	public QueryResult(double value) {
		super(value);
	}
	
	@Override
	public SLogoParsingException getException() {
		return null;
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
