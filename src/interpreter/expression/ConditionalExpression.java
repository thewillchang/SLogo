package interpreter.expression;

import interpreter.CommandReferenceLibrary;
import interpreter.expression.conditional.ConditionalResult;
import interpreter.result.SLogoResult;
import java.util.ArrayDeque;
import java.util.Deque;
import model.MainModel;
import transitionstate.NullTransitionState;
import exceptions.SLogoParsingException;

/**
 * superclass of SLogoExpressions for conditionals
 * @author Will Chang
 *
 */
public abstract class ConditionalExpression implements SLogoExpression {

    //TODO Maybe have all expressions extend/implement ExpressionEvaluator...???
    //TODO Add resource bundle to ConditionalExpression??? Or CommandReferenceLibrary
    //That can specify numArgs through a getter....
    
    
    protected Deque<SLogoExpression> myArguments;
    protected Deque<Double> valuesToCompare;
    protected int myNumArgs;
    
    protected CommandReferenceLibrary myLibrary;
    protected MainModel myModel;
    protected String myValue;
    
    public ConditionalExpression () {
        myArguments = new ArrayDeque<>();
        valuesToCompare = new ArrayDeque<>();
    }
    
    public void setNumArgs(int value) {
        myNumArgs = value;
    }
    
    @Override
    public void loadArguments(Deque<SLogoExpression> args) 
            throws SLogoParsingException, NullPointerException {
        //specifyNumberAndLoad(args,myNumArgs);
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
    

    /*public void specifyNumberAndLoad (Deque<SLogoExpression> args, int numArgs) 
            throws SLogoParsingException, NullPointerException {
        for(int i = 0 ; i < numArgs ; i++) {
            myArguments.add(args.pop());	            
        }   
    }*/

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
        SLogoResult myResult = new ConditionalResult();
        boolean condition = true;
        while(!results.isEmpty()) {
            argument = results.pop();
            condition = condition && hasSatisfiedCondition(argument);
            myResult.getTransition().addAll(argument.getTransition());
        }
        myResult.setValue(condition? 1 : 0);
        //myResult.getTransition().add(new NullTransitionState());
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
    
    protected abstract boolean hasSatisfiedCondition(SLogoResult argument);
    
    
}
