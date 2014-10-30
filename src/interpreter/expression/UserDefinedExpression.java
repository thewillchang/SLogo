package interpreter.expression;

import interpreter.CommandReferenceLibrary;
import interpreter.result.SLogoResult;
import interpreter.result.UserDefinedResult;
import java.util.ArrayDeque;
import java.util.Deque;
import model.MainModel;
import exceptions.SLogoParsingException;


/**
 * class of SLogoExpressions for User Defined Expressions
 *
 * @author Will Chang and Jonathan Tseng
 *
 */
public abstract class UserDefinedExpression implements SLogoExpression {
    protected CommandReferenceLibrary myLibrary;
    protected MainModel myModel;
    protected int myNumArgs;
    protected Deque<SLogoExpression> myArguments;
    protected String myValue;

    public UserDefinedExpression () {
        myArguments = new ArrayDeque<>();
    }

    @Override
    public void setNumArgs (int value) {
        myNumArgs = value;
    }

    @Override
    public void loadLibrary (CommandReferenceLibrary library) {
        myLibrary = library;
    }

    @Override
    public void loadModel (MainModel model) {
        myModel = model;
    }

    @Override
    public void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException,
    NullPointerException {
        for (int i = 0; i < myNumArgs; i++) {
            myArguments.add(args.pop());
        }
    }

    @Override
    public int getNumArgs () {
        return myNumArgs;
    }

    @Override
    public void setValue (String value) {
        myValue = value;
    }

    @Override
    public String getValue () {
        return myValue;
    }

    @Override
    public SLogoResult evaluate () {
        return new UserDefinedResult();
    }
}
