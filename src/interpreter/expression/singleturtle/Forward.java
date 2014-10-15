package interpreter.expression;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;

/**
 * 
 * @author Will Chang
 *
 */
public class Forward extends TurtleCommandExpression {
    private Deque<SLogoExpression> myParameters;

    public Forward () {
        myParameters = new ArrayDeque<>();
    }
    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        try {
            myParameters.add(args.pop());
        }
        catch (NullPointerException e) {
            System.out.println("Empty Parameters List");
        }
    }

    @Override
    public SLogoResult evaluate() {
        SLogoResult previousResult = myParameters.pop().evaluate();
        //TODO Edit transition states to only hold delta values, that is,
        //only hold changes that are not dependent on previous changes, only values
        
        //TransitionState prevTransition = previousResult.getTransition();
        /*TransitionState nextTransition = new TransitionState(prevTransition.getPenUp(), 
                                                             prevTransition.getTurtleVisible(), 
                                                             previousResult.getValue(), 
                                                             prevTransition.getRotateClockwise(),
                                                             prevTransition.getRotateCounterClockwise());*/
        TransitionState nextTransition = new TransitionState(false, 
                                                             true, 
                                                             previousResult.getValue(), 
                                                             0,
                                                             0);
        SLogoResult myResult = new TurtleCommandResult(previousResult.getValue());
        myResult.getTransition().add(nextTransition);
        myResult.getTransition().addAll(previousResult.getTransition());
        return myResult;

    }


}
