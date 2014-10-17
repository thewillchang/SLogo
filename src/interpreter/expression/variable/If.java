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

public class If implements SLogoExpression {
    private SLogoExpression myCondition;
    private List<SLogoExpression>  myList = new ArrayList<>();

    //if expr is not 0, runs the commands given in the list
    //returns the value of the final command executed

    @Override
    public void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException,
    NullPointerException {
        myCondition = args.pop();

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

        int bool = (int) myCondition.evaluate().getValue();
        if (bool != 0) {
            for(SLogoExpression expression : myList) {
                myResults.add(expression.evaluate());
            }
            for(SLogoResult result : myResults) {
                transitionStates.addAll(result.getTransition());    
            }
            myResult.setValue(myResults.getLast().getValue());
        }
        else {
            myResult.setValue(0);
        }
        
        return myResult;
    }
}