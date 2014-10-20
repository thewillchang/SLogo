package interpreter.expression;

import java.util.Deque;
import model.MainModel;
import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;

/**
 * superclass for SLogoExpressions that are purely syntax
 * examples include variables, constant numbers, and brackets
 * @author Jonathan Tseng
 *
 */
public abstract class SyntaxExpression implements SLogoExpression {
    protected CommandReferenceLibrary myLibrary;
    protected MainModel myModel;
    protected int myNumArgs;
    
    public SyntaxExpression() {
        
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
    public void loadArguments(Deque<SLogoExpression> args) {
        // TODO Auto-generated method stub

    }
    
   

    public abstract void setValue(String value);

    @Override
    public SLogoResult evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

}
