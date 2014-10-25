package interpreter.expression.query;

import interpreter.CommandReferenceLibrary;
import interpreter.expression.TurtleQueryExpression;

/**
 * 
 * @author Abhishek B
 *
 */
public class Heading extends TurtleQueryExpression {

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
