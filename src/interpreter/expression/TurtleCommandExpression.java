package interpreter.expression.turtlecommand;

<<<<<<< Updated upstream
import java.util.Deque;
=======
>>>>>>> Stashed changes
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

import java.util.List;

/**
 * superclass for SLogoExpressions that are commands
 * @author Jonathan Tseng
 *
 */
public abstract class TurtleCommandExpression implements SLogoExpression {

	@Override
	public void loadArguments(Deque<SLogoExpression> args) {
		// TODO Auto-generated method stub

	}

	@Override
	public SLogoResult evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
