package interpreter.expression;

<<<<<<< Updated upstream
import java.util.Deque;
=======
>>>>>>> Stashed changes
import interpreter.SLogoResult;

import java.util.List;

/**
 * superclass for SLogoExpressions that are Turtle Queries
 * @author Jonathan Tseng
 *
 */
public abstract class TurtleQueryExpression implements SLogoExpression {

	@Override
<<<<<<< Updated upstream
	public void loadArguments(Deque<SLogoExpression> args) {
=======
	public void loadArguments(List<SLogoExpression> args) {

>>>>>>> Stashed changes
		// TODO Auto-generated method stub

	}

	@Override
	public SLogoResult evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
