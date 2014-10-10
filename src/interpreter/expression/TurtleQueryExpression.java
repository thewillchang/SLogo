package interpreter.expression;

import java.util.List;
import interpreter.SLogoResult;

/**
 * superclass for SLogoExpressions that are Turtle Queries
 * @author Jonathan Tseng
 *
 */
public abstract class TurtleQueryExpression implements SLogoExpression {

	@Override
	public void loadArguments(List<SLogoExpression> args) {
		// TODO Auto-generated method stub

	}

	@Override
	public SLogoResult evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
