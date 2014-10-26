package interpreter.expression;

import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;
import interpreter.expression.conditional.ConditionalResult;
import java.util.ArrayDeque;
import java.util.Deque;
import model.MainModel;
import exceptions.SLogoParsingException;

/**
 * superclass of SLogoExpressions for Display
 * 
 * @author Abhishek B
 *
 */
public abstract class DisplayExpression implements SLogoExpression {

	protected Deque<SLogoExpression> myArguments;
	protected Deque<Double> valuesToCompare;
	protected int myNumArgs;

	protected CommandReferenceLibrary myLibrary;
	protected MainModel myModel;
	protected String myValue;

	public DisplayExpression() {
		myArguments = new ArrayDeque<>();
		valuesToCompare = new ArrayDeque<>();
	}

	public void setNumArgs(int value) {
		myNumArgs = value;
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

	@Override
	public void loadArguments(Deque<SLogoExpression> args)
			throws SLogoParsingException, NullPointerException {
		// specifyNumberAndLoad(args,myNumArgs);
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
		while (!myArguments.isEmpty()) {
			results.add(myArguments.pop().evaluate());
		}
		return applyOperatorAndMerge(results);
	}

	protected SLogoResult applyOperatorAndMerge(Deque<SLogoResult> results) {
		SLogoResult argument;
		SLogoResult myResult = new ConditionalResult();
		boolean condition = true;
		while (!results.isEmpty()) {
			argument = results.pop();
			myResult.getTransition().addAll(argument.getTransition());
		}
		myResult.setValue(condition ? 1 : 0);
		// myResult.getTransition().add(new NullTransitionState());
		return myResult;
	}
}
