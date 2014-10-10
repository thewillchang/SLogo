package turtle.animation;

import javafx.scene.Node;
import transitionstate.TransitionState;
import turtle.Turtle;

public abstract class RotateAnimation extends SLogoAnimation {

	private Node myTurtle;
	private double myDegrees;
	
	protected RotateAnimation(boolean clockwise) {
		attachFrame(event -> updateRotate(clockwise));
	}
	
	/**
	 * attachs a turtle to animate with the transition state to be animated
	 * @param turtleViewController
	 * @param degrees
	 */
	protected void attachTurtle(Turtle turtle, TransitionState transitionState, boolean clockwise) {
		myTurtle = turtle.getTurtle();
		myDegrees = (clockwise) ? transitionState.getRotateClockwise() : transitionState.getRotateCounterClockwise();
		setAnimationLength(myDegrees);
	}
	
	/**
	 * rotates the objects to be animated
	 */
	private void updateRotate(boolean clockwise) {
		if (Math.abs(myDegrees) < 1) {
			myTurtle.setRotate((myTurtle.getRotate() - myDegrees) % 360);
		} else {
			int rotation = (clockwise) ? 1 : -1;
			myTurtle.setRotate((myTurtle.getRotate() + rotation) % 360);
			myDegrees -= rotation;
		}
	}

}
