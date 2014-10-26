package interpreter.expression.singleturtle;

import interpreter.SLogoResult;
import interpreter.expression.TurtleCommandExpression;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;
import transitionstate.TransitionState.PenChange;
import transitionstate.TransitionState.VisibleChange;
import turtle.Turtle;

/**
 * 
 * @author Will Chang
 *
 */

public class SetPosition extends TurtleCommandExpression {

    @Override
    protected void setNextTransition (SLogoResult myResult, Deque<Double> values) {
        List<Turtle> allTurtles = myModel.getTurtles();
        Double distance = 0.0;
        Double rotate = 0.0;
        if(!allTurtles.isEmpty()) {
            Turtle turtle = allTurtles.get(allTurtles.size()-1);
            Double deltaX = values.pop() - turtle.getX();
            Double deltaY = values.pop() - turtle.getY();
            if(x)        
            distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        }
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, 
                                                         VisibleChange.NO_CHANGE, 0,    , 0));
        myResult.setValue(distance);
    }

}
