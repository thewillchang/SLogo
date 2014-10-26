package interpreter.expression.singleturtle;

import interpreter.SLogoResult	;
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

public class SetHeading extends TurtleCommandExpression {

    @Override
    protected void setNextTransition (SLogoResult myResult, Deque<Double> values) {
        List<Turtle> allTurtles = myModel.getTurtles();
        Double value = values.peek();
        if(!allTurtles.isEmpty()) {
            Turtle turtle = allTurtles.get(allTurtles.size()-1);
            value -= turtle.getHeading();
        }
        myResult.getTransition().add(new TransitionState(PenChange.NO_CHANGE, VisibleChange.NO_CHANGE, 0, value, 0));
        myResult.setValue(value);
    }

}
