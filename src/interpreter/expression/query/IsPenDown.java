package interpreter.expression.query;

import interpreter.CommandReferenceLibrary;
import interpreter.expression.TurtleQueryExpression;

/**
 * Expression to query if the pen is down
 * @author Abhishek B
 *
 */
public class IsPenDown extends TurtleQueryExpression {

	/**
	 * Return a double representing whether the pen is up or down
	 * 1 if the pen is down, 0 if the pen is up
	 */
	@Override
	public void setNumArgs(int value) {
	}

	@Override
	public void loadLibrary(CommandReferenceLibrary library) {
		
	}
	
	@Override
	public int getNumArgs(){
		return 0;
	}
}
