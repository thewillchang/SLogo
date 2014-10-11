package interpreter.expression;

import java.util.List;
import interpreter.SLogoResult;

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
	public void loadArguments(List<SLogoExpression> args);
	
	/**
	 * evaluates the expression and returns an SLogoResult
	 * @return
	 */
	public SLogoResult evaluate();
	
}
