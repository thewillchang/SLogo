package interpreter.expression.query;

import interpreter.CommandReferenceLibrary;
import interpreter.expression.TurtleQueryExpression;

/**
 * Expression to query what angle the turtle is facing
 * @author Abhishek B
 *
 */
public class Heading extends TurtleQueryExpression {

	/**
	 * Return a double representing the angle that the
	 * currently selected turtle is facing
	 */
	@Override
	public void setNumArgs(int value) {	
	}

	@Override
	public void loadLibrary(CommandReferenceLibrary library) {
		
	}

	@Override
	public int getNumArgs() {
		return 0;
	}

}
