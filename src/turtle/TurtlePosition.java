package turtle;

import javafx.geometry.Point2D;



/**
 * Model for Turtle
 * @author Tanaka Jimha
 * @author Jonathan Tseng
 *
 */
public class TurtlePosition {
	
	private double myXPosition;
	private double myYPosition;
	private double myRotate;
	
	public TurtlePosition() {
		myXPosition = 0;
		myYPosition = 0;
		myRotate = 0;
	}
	
	public double getRotate() {
		return myRotate;
	}
	
	public void updateCoordinates(Point2D coordinates) {
		myXPosition = coordinates.getX();
		myYPosition = coordinates.getY();
	}
	
	public void setRotate(double rotate) {
		myRotate = rotate;
	}
	
	public void update(TurtleViewController turtleViewController) {
		myXPosition = turtleViewController.getNode().getTranslateX();
		myYPosition = turtleViewController.getNode().getTranslateY() * -1;
	}
	
	public Point2D getPosition() {
		return new Point2D(myXPosition, myYPosition);
	}
	
}
