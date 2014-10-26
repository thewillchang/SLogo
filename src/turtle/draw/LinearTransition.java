package turtle.draw;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Duration;
import viewcontroller.turtlegrid.GridViewController;

/**
 * abstract superclass for lineear animations
 * checks/handles wrapping
 * @author Jonathan Tseng
 *
 */
public abstract class LinearTransition extends SLogoTransition {

	private boolean myFirst;
	protected double myStartX;
	protected double myStartY;
	protected double myX;
	protected double myY;
	protected double myDistance;
	protected double myDoneFrac;
	protected boolean myWrappingOccurred;
	
	protected LinearTransition() {
		super();
		myDoneFrac = 0;
		myDistance = 0;
		myFirst = true;
	}

	protected enum Wrapping {
		TOP, RIGHT, BOTTOM, LEFT, NONE
	}
	
	public void setDistance(double distance) {
		myDistance = distance;
		double time = (distance == 0) ? 1 : Math.abs(distance * 10);
		setCycleDuration(new Duration(time));
	}
	
	@Override
	protected void interpolate(double frac) {
		if (myFirst) {
			setStartPoint();
			myFirst = false;
		}
		setChanges();
		Point2D newStartPoint = checkWrapping();
		if (myWrappingOccurred) {
			performWrappingChanges(newStartPoint, frac);
		}
		interpolateChanges(frac);
		myWrappingOccurred = false;
	}
	
	protected abstract void interpolateChanges(double frac);
	
	protected abstract void performWrappingChanges(Point2D newStartPoint, double frac);
	
	protected void setStartPoint(double x, double y) {
		myStartX = x;
		myStartY = y;
	}
	
	protected abstract void setStartPoint();
	
	protected Point2D checkWrapping() {
		Node turtleNode = myTurtle.getTurtle();
		double x = turtleNode.getTranslateX();
		double y = turtleNode.getTranslateY();
		if (turtleNode.getTranslateX() > GridViewController.SIZE.width - myTurtle.getTurtleRadius()) {
			x = myTurtle.getTurtleRadius();
		} else if (turtleNode.getTranslateX() < myTurtle.getTurtleRadius()) {
			x = GridViewController.SIZE.width - myTurtle.getTurtleRadius();
		} else if (turtleNode.getTranslateY() > GridViewController.SIZE.height - myTurtle.getTurtleRadius()) {
			y = myTurtle.getTurtleRadius();
		} else if (turtleNode.getTranslateY() < myTurtle.getTurtleRadius()) {
			y = GridViewController.SIZE.height - myTurtle.getTurtleRadius();
		} else {
			return new Point2D(myStartX, myStartY);
		}
		myWrappingOccurred = true;
		return new Point2D(x, y);
	}
	
	private void setChanges() {
		double rotation = scaleRotation(myTurtle.getTurtle().getRotate());
		myX = myDistance * Math.sin(Math.toRadians(rotation));
		myY = myDistance * -1 * Math.cos(Math.toRadians(rotation));
	}
	
	private double scaleRotation(double rotate) {
		double rotation = rotate % 360;
		if (rotation < 0) {
			rotation = 360 + rotation;
		}
		return rotation;	
	}

	
}