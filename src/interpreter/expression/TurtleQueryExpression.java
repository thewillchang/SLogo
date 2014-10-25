package interpreter.expression;

import java.util.ArrayDeque;
import java.util.Deque;

import model.MainModel;
import model.UserDefinedVariablesModel;
import interpreter.SLogoResult;

/**
 * superclass for SLogoExpressions that are Turtle Queries
 * 
 * @author Abhishek B
 *
 */
public abstract class TurtleQueryExpression implements SLogoExpression {

	protected MainModel myModel;

	/**
	 * Querying expressions do not take arguments, so this is not defined
	 */
	@Override
	public void loadArguments(Deque<SLogoExpression> args) {
	}

	@Override
	public void loadModel(MainModel model) {
		myModel = model;
	}

	@Override
	public SLogoResult evaluate() {
		Deque<SLogoResult> results = new ArrayDeque<>();
		
		return null;
	}
	
	@Override
	public int getNumArgs() {
		return 0;
	}
	
	protected abstract double getValueFromModel(MainModel model) ;

}
