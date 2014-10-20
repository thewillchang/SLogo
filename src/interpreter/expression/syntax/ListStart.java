package interpreter.expression.syntax;

import interpreter.SLogoResult;
import interpreter.SyntaxResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SyntaxExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;

/**
 * 
 * @author Will
 *
 */

//TODO refactor, move logic for loading arguments into the parser...
//refactor from destroying the list...
public class ListStart extends SyntaxExpression {

    @Override
    public void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException, NullPointerException{
        while(!args.isEmpty()) {
            SLogoExpression argument = args.pop();
            if(argument instanceof ListEnd) {
                break;
            }
            else {
                myArguments.add(argument);
            }
        }
        if(myArguments.size() <= 1 || !(myArguments.peekLast() instanceof ListEnd)) {
            throw new SLogoParsingException();
        }
    }

    @Override
    public SLogoResult evaluate () {
        Deque<SLogoResult> results = new ArrayDeque<>();
        for(SLogoExpression expression : myArguments) {
            results.add(expression.evaluate());
        }
        
        return merge(results);
    }
    
    private SLogoResult merge (Deque<SLogoResult> results) {
        SLogoResult myResult = new SyntaxResult(results.getLast().getValue());
        List<TransitionState> transitionStates = myResult.getTransition();
        for(SLogoResult result : results) {
            transitionStates.addAll(result.getTransition());
        }
        return myResult;
    }

    @Override
    public void setValue (String value) {
        // TODO Auto-generated method stub

    }



}