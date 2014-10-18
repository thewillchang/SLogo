package interpreter.expression;

import java.util.Deque;
import exceptions.SLogoParsingException;
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
	 * @throws NullPointerException 
	 * @throws SLogoParsingException 
	 */
	public void loadArguments(Deque<SLogoExpression> args) throws SLogoParsingException, NullPointerException;
	
	/**
	 * evaluates the expression and returns an SLogoResult
	 * @return
	 * @throws SLogoParsingException 
	 */
	public SLogoResult evaluate() throws SLogoParsingException;
	
}
