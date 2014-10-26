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
 * @author Abhishek Balakrishnan
 *
 */

public class SetPosition extends TurtleCommandExpression {

	@Override
	protected void setNextTransition(SLogoResult myResult, Deque<Double> values) {
		List<Turtle> allTurtles = myModel.getTurtles();
		double currentHeading = 0.0;
		double distance = 0.0;
		double rotate = 0.0;
		if (!allTurtles.isEmpty()) {
			Turtle turtle = allTurtles.get(allTurtles.size() - 1);
			currentHeading = turtle.getHeading();
			double destinationX = values.pop();
			double destinationY = values.pop();
			double turtleX = turtle.getX();
			double turtleY = turtle.getY();
			double deltaX = turtleX - destinationX;
			double deltaY = turtleY - destinationY;

			distance = pythagoreanTheorem(deltaX, deltaY);
			rotate = getThetaValue(deltaX, deltaY);
		}

		myResult.getTransition().add(
				new TransitionState(PenChange.NO_CHANGE,
						VisibleChange.NO_CHANGE, distance, rotate - currentHeading, 0));
		myResult.setValue(distance);
	}

	private double pythagoreanTheorem(double x, double y) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	private double getThetaValue(double deltaX, double deltaY) {
		if (deltaY < 0 && deltaX < 0) {
			return 90 - Math.atan(deltaY / deltaX);
		}
		if (deltaY < 0 && deltaX > 0) {
			return 360 - Math.atan(deltaX / deltaY);
		}
		if (deltaY > 0 && deltaX < 0) {
			return 180 - Math.atan(deltaX / deltaY);
		}
		if (deltaY > 0 && deltaX > 0) {
			return 270 - Math.atan(deltaY / deltaX);
		}
		
		return 0;
	}
}