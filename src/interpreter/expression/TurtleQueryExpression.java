package interpreter.expression;

import java.util.Deque;
import model.MainModel;
import interpreter.SLogoResult;

/**
 * superclass for SLogoExpressions that are Turtle Queries
 * 
 * @author Abhishek B
 *
 */
public abstract class TurtleQueryExpression implements SLogoExpression {

	protected MainModel myModel;
	protected String myValue;

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
		return null;
	}
	
	@Override
	    public void setValue(String value) {
	        myValue = value;
	    }
	
	@Override
	    public String getValue () {
	        return myValue;
	    }

}
