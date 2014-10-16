package interpreter.expression.turtlecommand;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
<<<<<<< Updated upstream
import java.util.Deque;
=======
import interpreter.expression.SLogoExpression;

>>>>>>> Stashed changes
import java.util.List;

import transitionstate.TransitionState;

<<<<<<< Updated upstream
public class Forward extends TurtleCommandExpression {
    private Deque<SLogoExpression> myParameters;

    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        try {
            myParameters.add(args.pop());
        }
        catch (NullPointerException e) {
            System.out.println("Empty Parameters List");
        }
=======
public class ForwardCommand extends TurtleCommandExpression {
    private SLogoExpression[] myParameters;
    
    @Override
    public void loadArguments(List<SLogoExpression> args) {
        myParameters =  (SLogoExpression[]) args.toArray();
>>>>>>> Stashed changes
    }

    @Override
    public SLogoResult evaluate() {
<<<<<<< Updated upstream
        SLogoResult previousResult = myParameters.pop().evaluate();
=======
        SLogoResult previousResult = myParameters[0].evaluate();
>>>>>>> Stashed changes
        TransitionState prevTransition = previousResult.getTransition().get(0);
        TransitionState nextTransition = new TransitionState(prevTransition.getPenUp(), 
                                                             prevTransition.getTurtleVisible(), 
                                                             previousResult.getValue(), 
                                                             prevTransition.getRotateClockwise(),
                                                             prevTransition.getRotateCounterClockwise());
        SLogoResult myResult = new TurtleCommandResult(previousResult.getValue());
        myResult.getTransition().add(nextTransition);
        myResult.getTransition().addAll(previousResult.getTransition());
        return myResult;

    }


}
