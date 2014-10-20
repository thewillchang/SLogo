package interpreter.expression.singleturtle;

import java.util.ArrayDeque;
import java.util.Deque;
import model.MainModel;
import exceptions.SLogoParsingException;
import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;


/**
 * superclass for SLogoExpressions that are commands
 * @author Will Chang and Jonathan Tseng
 *
 */
public abstract class TurtleCommandExpression implements SLogoExpression {
    protected Deque<SLogoExpression> myArguments;
    protected int myNumArgs;
    protected CommandReferenceLibrary myLibrary;
    protected MainModel myModel;

    public TurtleCommandExpression() {
        myArguments = new ArrayDeque<>();
    }

    public void setNumArgs(int value) {
        myNumArgs = value;
    }
    
    @Override
    public void loadArguments(Deque<SLogoExpression> args)  
            throws SLogoParsingException, NullPointerException {
        for(int i = 0 ; i < myNumArgs ; i++) {
            myArguments.add(args.pop());                    
        }
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
    public SLogoResult evaluate() {
        Deque<SLogoResult> results = new ArrayDeque<>();
        while(!myArguments.isEmpty()) {
            results.add(myArguments.pop().evaluate());
        }
        return applyOperatorAndMerge(results);
    }

    protected SLogoResult applyOperatorAndMerge (Deque<SLogoResult> results) {
        SLogoResult argument;
        SLogoResult myResult = new TurtleCommandResult();
        argument = results.pop();
        myResult.getTransition().addAll(argument.getTransition());
        double value = argument.getValue();
        myResult.setValue(value);
        setNextTransition(myResult, value);
        return myResult;
    }
    
    protected abstract void setNextTransition(SLogoResult myResult, double value); 
}
