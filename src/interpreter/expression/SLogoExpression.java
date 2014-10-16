package interpreter.expression;

<<<<<<< Updated upstream
import java.util.Deque;
=======
>>>>>>> Stashed changes
import interpreter.SLogoResult;

import java.util.List;

/**
 * Interface that SLogo Expressions must implement
 * @author Jonathan Tseng
 *
 */
public interface SLogoExpression {

	/**
	 * loads the list of expressions as arguments for the expression
	 * @param args
	 */
	public void loadArguments(Deque<SLogoExpression> args);
	
	/**
	 * evaluates the expression and returns an SLogoResult
	 * @return
	 */
	public SLogoResult evaluate();
	
}
