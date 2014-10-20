package interpreter.expression;

import java.util.Deque;
import model.MainModel;
import exceptions.SLogoParsingException;
import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;

/**
 * Interface that SLogo Expressions must implement
 * @author Jonathan Tseng
 *
 */
public interface SLogoExpression {
        //TODO implement iterator
    
	/**
	 * loads the list of expressions as arguments for the expression
	 * @param args
	 * @throws NullPointerException 
	 * @throws SLogoParsingException 
	 */
	public abstract void loadArguments(Deque<SLogoExpression> args) throws SLogoParsingException, NullPointerException;
	
	public void setNumArgs(int value);
	
	public void loadLibrary(CommandReferenceLibrary library);
	
	/**
	 * Loads the model
	 * @param mode
	 */
	public void loadModel(MainModel model);
	
	
	
	/**
	 * evaluates the expression and returns an SLogoResult
	 * @return
	 * @throws SLogoParsingException 
	 */
	public abstract SLogoResult evaluate();
	
	
	
}
