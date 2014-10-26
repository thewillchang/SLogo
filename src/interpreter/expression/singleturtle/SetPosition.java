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

	private final int[][] thetaArray = { { 90, 180 }, { 360, 270 } };

	@Override
	protected void setNextTransition(SLogoResult myResult, Deque<Double> values) {
		List<Turtle> allTurtles = myModel.getTurtles();
		double distance = 0.0;
		double rotate = 0.0;
		if (!allTurtles.isEmpty()) {
			Turtle turtle = allTurtles.get(allTurtles.size() - 1);
			double destinationX = values.pop();
			double destinationY = values.pop();
			double turtleX = turtle.getX();
			double turtleY = turtle.getY();
			double deltaX = destinationX - turtleX;
			double deltaY = destinationY - turtleY;

			distance = pythagoreanTheorem(deltaX, deltaY);

		}

		myResult.getTransition().add(
				new TransitionState(PenChange.NO_CHANGE,
						VisibleChange.NO_CHANGE, 0, 0, rotate));
		myResult.setValue(distance);
	}

	private double pythagoreanTheorem(double x, double y) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}