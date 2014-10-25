package interpreter.expression.query;

import model.MainModel;
import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;
import interpreter.expression.TurtleQueryExpression;

/**
 * 
 * @author Abhishek B
 *
 */
public class XCoordinate extends TurtleQueryExpression {

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

	@Override
	protected double getValueFromModel(MainModel model) {
		return 0;
	}

}
