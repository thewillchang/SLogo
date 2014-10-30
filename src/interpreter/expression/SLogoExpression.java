package interpreter.expression;

import interpreter.CommandReferenceLibrary;
import interpreter.result.SLogoResult;
import java.util.Deque;
import model.MainModel;
import exceptions.SLogoParsingException;


/**
 * Interface that SLogo Expressions must implement
 *
 * @author Jonathan Tseng
 *
 */
public interface SLogoExpression {
    // TODO implement iterator

    /**
     * loads the list of expressions as arguments for the expression
     *
     * @param args
     * @throws NullPointerException
     * @throws SLogoParsingException
     */
    public abstract void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException,
    NullPointerException;

    public abstract void setNumArgs (int value);

    public abstract void loadLibrary (CommandReferenceLibrary library);

    /**
     * Loads the model
     *
     * @param mode
     */
    public abstract void loadModel (MainModel model);

    public abstract int getNumArgs ();

    /**
     * evaluates the expression and returns an SLogoResult
     *
     * @return
     * @throws SLogoParsingException
     */
    public abstract SLogoResult evaluate ();

    public abstract void setValue (String value);

    public abstract String getValue ();

}
