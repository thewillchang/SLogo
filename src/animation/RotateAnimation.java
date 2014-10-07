package animation;

import javafx.scene.Node;
import transitionstate.TransitionState;
import viewcontroller.TurtleViewController;

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
	protected void attachTurtle(TurtleViewController turtleViewController, TransitionState transitionState, boolean clockwise) {
		myTurtle = turtleViewController.getNode();
		myDegrees = (clockwise) ? transitionState.getRotateClockwise() : transitionState.getRotateCounterClockwise();
		setAnimationLength(myDegrees);
	}
	
	public void attachInfo(TurtleViewController turtleViewController, double degrees) {
		myTurtle = turtleViewController.getNode();
		myDegrees = degrees;
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
