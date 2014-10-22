package turtle.draw;

import viewcontroller.turtlegrid.GridViewController;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Duration;

public abstract class LinearTransition extends SLogoTransition {

	protected double myStartX;
	protected double myStartY;
	protected double myX;
	protected double myY;
	protected double myDistance;
	protected double myDoneFrac;
	
	protected LinearTransition() {
		super();
		myDoneFrac = 0;
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
		setChanges();
	}
	
	protected abstract void performWrappingChanges(double frac);
	
	protected void setStartPoint(double x, double y) {
		myStartX = x;
		myStartY = y;
	}
	
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