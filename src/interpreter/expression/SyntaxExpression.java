package interpreter.expression;

import java.util.ArrayDeque;
import java.util.Deque;
import exceptions.SLogoParsingException;
import model.MainModel;
import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;

/**
 * superclass for SLogoExpressions that are purely syntax
 * examples include variables, constant numbers, and brackets
 * @author Will Chang and Jonathan Tseng
 *
 */
public abstract class SyntaxExpression implements SLogoExpression {
    protected CommandReferenceLibrary myLibrary;
    protected MainModel myModel;
    protected int myNumArgs;
    protected Deque<SLogoExpression> myArguments;
    
    public SyntaxExpression() {
        myArguments = new ArrayDeque<>();
    }
    
    @Override
    public void setNumArgs (int value) {
        myNumArgs = value;
    }
    
    @Override
    public void loadLibrary(CommandReferenceLibrary library) {
        myLibrary = library;
    }
    @Override
    public void loadModel(MainModel model) {
        myModel = model;
    }
    
    @Override
    public void loadArguments(Deque<SLogoExpression> args) throws SLogoParsingException, NullPointerException{
        for(int i = 0; i < myNumArgs; i++) {
            myArguments.add(args.pop());
        }
    }
    
   

    public abstract void setValue(String value);

    @Override
    public SLogoResult evaluate() {
        return null;
    }

}
