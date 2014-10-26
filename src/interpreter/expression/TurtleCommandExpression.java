package interpreter.expression;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import model.MainModel;
import exceptions.SLogoParsingException;
import interpreter.CommandReferenceLibrary;
import interpreter.result.SLogoResult;
import interpreter.result.TurtleCommandResult;


/**
 * superclass for SLogoExpressions that are commands
 * @author Will Chang
 *
 */
public abstract class TurtleCommandExpression implements SLogoExpression {
    protected Deque<SLogoExpression> myArguments;
    protected int myNumArgs;
    protected CommandReferenceLibrary myLibrary;
    protected MainModel myModel;
    protected String myValue;

    public TurtleCommandExpression() {
        super();
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
        for(SLogoExpression expression : myArguments) {
            results.add(expression.evaluate());
        }
        return applyOperatorAndMerge(results);
    }

    protected SLogoResult applyOperatorAndMerge (Deque<SLogoResult> results) {
        SLogoResult argument;
        SLogoResult myResult = new TurtleCommandResult();
        Deque<Double> values = new ArrayDeque<>();

        for(SLogoResult result : results) {
            argument = result;
            myResult.getTransition().addAll(argument.getTransition());
            values.add( argument.getValue());
        }
        setNextTransition(myResult, values);
        return myResult;
    }

    @Override
    public int getNumArgs () {
        return myNumArgs;
    }

    @Override
    public void setValue(String value) {
        myValue = value;
    }

    @Override
    public String getValue () {
        return myValue;
    }

    protected abstract void setNextTransition(SLogoResult myResult, Deque<Double> value); 
}
