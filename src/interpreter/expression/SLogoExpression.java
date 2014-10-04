package interpreter.expression;

import interpreter.SLogoResult;

import java.util.Collection;

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
	public void loadArguments(Collection<SLogoExpression> args);
	
	/**
	 * evaluates the expression and returns an SLogoResult
	 * @return
	 */
	public SLogoResult evaluate();
	
}
