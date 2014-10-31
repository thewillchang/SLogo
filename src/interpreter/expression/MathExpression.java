// This entire file is part of my masterpiece.
// William Chang
package interpreter.expression;

import interpreter.CommandReferenceLibrary;
import interpreter.expression.math.MathResult;
import interpreter.result.SLogoResult;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import model.MainModel;
import transitionstate.NullTransitionState;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

/**
 * Superclass of SLogoExpressions for Math expressions
 * 
 * @author Will Chang
 *
 */
public abstract class MathExpression implements SLogoExpression {

	protected Deque<SLogoExpression> myArguments;
	protected int myNumArgs;
	protected CommandReferenceLibrary myLibrary;
	protected MainModel myModel;
	protected String myValue;

	public MathExpression() {
		myArguments = new ArrayDeque<>();
	}

	@Override
	public void setNumArgs(int value) {
		myNumArgs = value;
	}

	@Override
	public void loadArguments(Deque<SLogoExpression> args)
			throws SLogoParsingException {
		if (args.size() < myNumArgs) {
			throw new SLogoParsingException();
		}
		for (int i = 0; i < myNumArgs; i++) {
			myArguments.add(args.pop());
		}
	}

	@Override
	public void loadLibrary(CommandReferenceLibrary library) {
		myLibrary = library;
	}

	@Override
	public void loadModel(MainModel model) {
		myModel = model;
	}

	@Override      
	public SLogoResult evaluate() {
		Deque<SLogoResult> results = new ArrayDeque<>();
		for (SLogoExpression argument : myArguments) {
			results.add(argument.evaluate());
		}
		return applyOperatorAndMerge(results);
	}

	/**
	 * Applies the Math operator and merges the results.
	 * @param results
	 * @return
	 */
	protected SLogoResult applyOperatorAndMerge(Deque<SLogoResult> results) {
		SLogoResult myResult = new MathResult();
		myResult.setValue(applyMath(results));
		mergePreviousResults(results, myResult);
		return myResult;
	}

	/**
	 * Applies the defined math operator in each subclass.
	 * @param results
	 * @return
	 */
	protected abstract double applyMath(Deque<SLogoResult> results);

	/**
	 * Merges the results
	 * @param results list to merge
	 * @param myResult result current expression is returning
	 */
	protected void mergePreviousResults(Deque<SLogoResult> results,
			SLogoResult myResult) {
		List<TransitionState> transitionStates = myResult.getTransition();
		for (SLogoResult result : results) {
			transitionStates.addAll(result.getTransition());
		}
		transitionStates.add(new NullTransitionState());
	}

	@Override
	public int getNumArgs() {
		return myNumArgs;
	}

	@Override
	public void setValue(String value) {
		myValue = value;
	}

	@Override
	public String getValue() {
		return myValue;
	}
}