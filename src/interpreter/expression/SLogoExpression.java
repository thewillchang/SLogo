// This entire file is part of my masterpiece.
// William Chang
package interpreter.expression;

import java.util.Deque;
import model.MainModel;
import exceptions.SLogoParsingException;
import interpreter.CommandReferenceLibrary;
import interpreter.result.SLogoResult;

/**
 * Interface that SLogo Expressions must implement
 * @author Jonathan Tseng and William Chang
 *
 */
public interface SLogoExpression {
    
	/**
	 * loads the list of expressions as arguments for the expression
	 * @param args
	 * @throws NullPointerException 
	 * @throws SLogoParsingException 
	 */
	public abstract void loadArguments(Deque<SLogoExpression> args) throws SLogoParsingException, NullPointerException;
	
	/**
	 * Sets the number of arguments
	 * @param value
	 */
	public abstract void setNumArgs(int value);
	
	/**
	 * Sets the library from the CommandReferenceLibrary
	 * @param library
	 */
	public abstract void loadLibrary(CommandReferenceLibrary library);
	
	/**
	 * Loads the model
	 * @param mode
	 */
	public abstract void loadModel(MainModel model);
	
	/**
	 * Gets the number of arguments for the expression.
	 * @return
	 */
	public abstract int getNumArgs();
	
	/**
	 * evaluates the expression and returns an SLogoResult
	 * @return
	 * @throws SLogoParsingException 
	 */
	public abstract SLogoResult evaluate();
	
	/**
	 * Sets the value of the expression
	 * @param value
	 */
	public abstract void setValue(String value);
	
	/**
	 * Gets the String value of the expression
	 * @return value
	 */
	public abstract String getValue ();
	
	
}