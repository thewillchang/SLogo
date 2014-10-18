package interpreter.expression.conditional;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import java.util.ArrayDeque;
import java.util.Deque;
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
    protected int myNumArgs;
    
    public ConditionalExpression () {
        myArguments = new ArrayDeque<>();

    }
    
    @Override
    public void loadArguments(Deque<SLogoExpression> args) 
            throws SLogoParsingException, NullPointerException {
        //specifyNumberAndLoad(args,myNumArgs);
        for(int i = 0 ; i < myNumArgs ; i++) {
            myArguments.add(args.pop());                    
        }
    }


    /*public void specifyNumberAndLoad (Deque<SLogoExpression> args, int numArgs) 
            throws SLogoParsingException, NullPointerException {
        for(int i = 0 ; i < numArgs ; i++) {
            myArguments.add(args.pop());	            
        }   
    }*/

    @Override
    public SLogoResult evaluate() throws SLogoParsingException, NullPointerException {
        Deque<SLogoResult> results = new ArrayDeque<>();
        while(!myArguments.isEmpty()) {
            results.add(myArguments.pop().evaluate());
        }
        return applyOperatorAndMerge(results);
    }
    
    protected SLogoResult applyOperatorAndMerge (Deque<SLogoResult> results) 
            throws SLogoParsingException {
        SLogoResult argument = results.pop();
        SLogoResult myResult = new ConditionalResult();
        boolean condition = true;
        while(!results.isEmpty()) {
            argument = results.pop();
            condition = condition && hasSatisfiedCondition(argument);
            myResult.getTransition().addAll(argument.getTransition());
        }
        myResult.setValue(condition? 1 : 0);
        return myResult;
    }
    
    protected abstract boolean hasSatisfiedCondition(SLogoResult argument);
    
    
}
