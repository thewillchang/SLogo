package interpreter.expression;

import java.util.Deque;

import model.MainModel;
import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;
import interpreter.expression.query.QueryResult;

/**
 * superclass for SLogoExpressions that are Turtle Queries
 * 
 * @author Abhishek B
 *
 */
public abstract class TurtleQueryExpression implements SLogoExpression {

	protected MainModel myModel;

	@Override
	public void setNumArgs(int value) {
	}

	/**
	 * Querying expressions do not take arguments, so this is not defined
	 */
	@Override
	public void loadArguments(Deque<SLogoExpression> args) {
	}

	@Override
	public void loadLibrary(CommandReferenceLibrary library) {

	}

	@Override
	public void loadModel(MainModel model) {
		myModel = model;
	}

	@Override
	public SLogoResult evaluate() {
		SLogoResult myResult = new QueryResult();
		myResult.setValue(getValueFromModel(myModel));
		return myResult;
	}

	@Override
	public int getNumArgs() {
		return 0;
	}

	protected abstract double getValueFromModel(MainModel model);

}
