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
    private int mySize;
    
    public ListStart () {
        super();
        mySize = 0;
    }
    @Override
    public void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException, NullPointerException{
        while(!args.isEmpty()) {
            SLogoExpression argument = args.pop();
            myArguments.add(argument);
            mySize++;
            if(argument instanceof ListEnd) {
                break;
            }
        }
        if(myArguments.size() == 0 || !(myArguments.peekLast() instanceof ListEnd)) {
            throw new SLogoParsingException();
        }
    }

    @Override
    public SLogoResult evaluate () {
        Deque<SLogoResult> results = new ArrayDeque<>();
        for(SLogoExpression expression : myArguments) {
            if(!(expression instanceof ListEnd))
            results.add(expression.evaluate());
        }
        return merge(results);
    }
    
    private SLogoResult merge (Deque<SLogoResult> results) {
        SLogoResult myResult = new SyntaxResult(results.getLast().getValue());
        List<TransitionState> transitionStates = myResult.getTransition();
        String commandLabels = myValue;
        for(SLogoResult result : results) {
            commandLabels.concat("|" + result.toString());
            transitionStates.addAll(result.getTransition());
        }
        myResult.setLabel(commandLabels);
        return myResult;
    }

    
    //TODO Refactor method name SetValue... 
    @Override
    public void setValue (String value) {
        myValue = value;
    }

}