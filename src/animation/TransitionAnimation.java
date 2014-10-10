package animation;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import model.Turtle;
import transitionstate.TransitionState;
import viewcontroller.GridViewController;

public class TransitionAnimation extends SLogoAnimation {

	private boolean myDone;
	private double myXMove;
	private double myYMove;
	private double myDistance;
	private Turtle myTurtle;
	private boolean first;
	private Point2D myLineStartingPoint;
	private boolean myPenDown;
	private int frameCount;
	
	public TransitionAnimation() {
		myDone = false;
		frameCount = 0;
		first = true;
		attachFrame(event -> updateTransition());
	}
	
	private void updateTransition() {
		if (myDone) return;
		frameCount++;
		if (first) {
			myLineStartingPoint = new Point2D(myTurtle.getTurtle().getTranslateX(), myTurtle.getTurtle().getTranslateY());
			first = false;
		}
		calculateMove();
		moveTurtle();
		drawPath();
		if (frameCount >= myDistance) {
			myTurtle.getPen().finishLine();
			//myTurtle.getPen().erase();
		} 
	}

	private void moveTurtle() {
		Node turtleNode = myTurtle.getTurtle();
		checkWrapping();
		turtleNode.setTranslateX(turtleNode.getTranslateX() + myXMove);
		turtleNode.setTranslateY(turtleNode.getTranslateY() + myYMove);
	}
	
	private void checkWrapping() {
		Node turtleNode = myTurtle.getTurtle();
		if (turtleNode.getTranslateX() + myXMove > GridViewController.SIZE.width / 2 - myTurtle.getTurtleRadius()) {
			turtleNode.setTranslateX(-GridViewController.SIZE.width / 2 + myTurtle.getTurtleRadius());
		} else if (turtleNode.getTranslateX() + myXMove < -GridViewController.SIZE.width / 2 + myTurtle.getTurtleRadius()) {
			turtleNode.setTranslateX(GridViewController.SIZE.width / 2 - myTurtle.getTurtleRadius());
		} else if (turtleNode.getTranslateY() + myYMove > GridViewController.SIZE.height / 2 - myTurtle.getTurtleRadius()) {
			turtleNode.setTranslateY(-GridViewController.SIZE.height / 2 + myTurtle.getTurtleRadius());
		} else if (turtleNode.getTranslateY() + myYMove < -GridViewController.SIZE.height / 2 + myTurtle.getTurtleRadius()) {
			turtleNode.setTranslateY(GridViewController.SIZE.height / 2 - myTurtle.getTurtleRadius());
		} else {
			myTurtle.getPen().erase();
			return;
		}
		myTurtle.getPen().finishLine();
		myLineStartingPoint = new Point2D(turtleNode.getTranslateX(), turtleNode.getTranslateY());
	}
	   
	private void drawPath() {
		Point2D endPoint = new Point2D(myTurtle.getTurtle().getTranslateX(),
				myTurtle.getTurtle().getTranslateY());
		myTurtle.getPen().drawLine(myLineStartingPoint, endPoint, myPenDown, myTurtle.getTurtle());
	}
	
	private void calculateMove() {
		Node turtleNode = myTurtle.getTurtle();
		myXMove = Math.abs(Math.sin(Math.toRadians(turtleNode.getRotate())));
		myYMove = Math.abs(Math.cos(Math.toRadians(turtleNode.getRotate())));
		double rotation = turtleNode.getRotate() % 360;
		if (rotation < 0) {
			myXMove = (rotation > -180) ? -1 * myXMove : myXMove;
			myYMove = (rotation > -90 || rotation < -270) ? myYMove : -1 * myYMove;
		} else {
			myXMove = (rotation > 180) ? -1 * myXMove : myXMove;
			myYMove = (rotation < 90 || rotation > 270) ? -1 * myYMove : myYMove;
		}
	}
	
	@Override
	public void attachTurtle(Turtle turtle, TransitionState transitionState) {
		myDone = transitionState.getMove() == 0;
		if (myDone) return;
		myTurtle = turtle;
		myPenDown = !transitionState.getPenUp();
		myDistance = transitionState.getMove();
		setAnimationLength(myDistance);
	}

}
