package interpreter.expression.variable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
import interpreter.ControlStructureResult;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.syntax.ListEnd;
import interpreter.expression.syntax.ListStart;

/**
 * 
 * @author Will
 *
 */

public class Repeat implements SLogoExpression {
    private SLogoExpression myMaxRep;
    private List<SLogoExpression>  myList = new ArrayList<>();
    
    @Override
    public void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException, NullPointerException{
                myMaxRep = args.pop();
                
                //Checks for list
                if(ListStart.class.equals(args.pop().getClass())) {
                    while(!ListEnd.class.equals(args.peek())) {
                        myList.add(args.pop());
                    }
                    //A safety check
                    if(ListEnd.class.equals(args.peek())) {
                        args.pop();
                    }
                    else {
                        throw new SLogoParsingException();
                    }
                }
                else {
                    throw new SLogoParsingException();
                }
        
    }
    

    @Override
    public SLogoResult evaluate () {
        SLogoResult myResult = new ControlStructureResult();
        List<TransitionState> transitionStates = myResult.getTransition();
        
        Deque<SLogoResult> myResults = new ArrayDeque<>();
       
        //Does the iterations, merging of the results...
        //TODO add ResultMerger???...
        //TODO add CommandReferenceLibrary to all expressions
        
        int numReps = (int) myMaxRep.evaluate().getValue();



        for(int i = 1 ; i <= numReps; i++) {
            //TODO set :repcount variable equal to i in Library
            myResults.clear();
            for(SLogoExpression expression : myList) {
                myResults.add(expression.evaluate());
            }
            for(SLogoResult result : myResults) {
                transitionStates.addAll(result.getTransition());    
            }
        }
        //Sets the result value to that of last result
        myResult.setValue(myResults.getLast().getValue());
        return myResult;
    }
}