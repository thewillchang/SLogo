package animation;

import javafx.scene.Node;
import transitionstate.TransitionState;
import viewcontroller.GridViewController;
import viewcontroller.TurtleViewController;

public class TransitionAnimation extends SLogoAnimation {

	private double myXMove;
	private double myYMove;
	private double myDistance;
	private TurtleViewController myTurtleViewController;
	private Node myTurtle;
	
	public TransitionAnimation() {
		attachFrame(event -> updateTransition());
	}
	
	private void updateTransition() {
		calculateMove();
		if (myTurtle.getTranslateX() + myXMove > GridViewController.SIZE.width / 2 - myTurtleViewController.getRadius()) {
			myTurtle.setTranslateX(-GridViewController.SIZE.width / 2 + myTurtleViewController.getRadius());
		} else if (myTurtle.getTranslateX() + myXMove < -GridViewController.SIZE.width / 2 + myTurtleViewController.getRadius()) {
			myTurtle.setTranslateX(GridViewController.SIZE.width / 2 - myTurtleViewController.getRadius());
		} else if (myTurtle.getTranslateY() + myYMove > GridViewController.SIZE.height / 2 - myTurtleViewController.getRadius()) {
			myTurtle.setTranslateY(-GridViewController.SIZE.height / 2 + myTurtleViewController.getRadius());
		} else if (myTurtle.getTranslateY() + myYMove < -GridViewController.SIZE.height / 2 + myTurtleViewController.getRadius()) {
			myTurtle.setTranslateY(GridViewController.SIZE.height / 2 - myTurtleViewController.getRadius());
		}
		myTurtle.setTranslateX(myTurtle.getTranslateX() + myXMove);
		myTurtle.setTranslateY(myTurtle.getTranslateY() + myYMove);
	}

	public void attachInfo(TurtleViewController turtleViewController, double distance) {
		myTurtleViewController = turtleViewController;
		myTurtle = myTurtleViewController.getNode();
		myDistance = distance;
		setAnimationLength(myDistance);
	}
	
	private void calculateMove() {
		myXMove = Math.abs(Math.sin(Math.toRadians(myTurtle.getRotate())));
		myYMove = Math.abs(Math.cos(Math.toRadians(myTurtle.getRotate())));
		double rotation = myTurtle.getRotate() % 360;
		if (rotation < 0) {
			myXMove = (rotation > -180) ? -1 * myXMove : myXMove;
			myYMove = (rotation > -90 || rotation < -270) ? myYMove : -1 * myYMove;
		} else {
			myXMove = (rotation > 180) ? -1 * myXMove : myXMove;
			myYMove = (rotation < 90 || rotation > 270) ? -1 * myYMove : myYMove;
		}
	}
	
	@Override
	public void attachTurtle(TurtleViewController turtleViewController,
			TransitionState transitionState) {
		myTurtleViewController = turtleViewController;
		myDistance = transitionState.getMove();
		setAnimationLength(myDistance);
	}

}
