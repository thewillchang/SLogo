package turtle;

import javafx.geometry.Point2D;



/**
 * Model for Turtle
 * @author Tanaka Jimha
 * @author Jonathan Tseng
 *
 */
public class TurtleModel {
	
	private double myXPosition;
	private double myYPosition;
	
	public TurtleModel() {
		myXPosition = 0;
		myYPosition = 0;
	}
	
	public void update(TurtleViewController turtleViewController) {
		myXPosition = turtleViewController.getNode().getTranslateX();
		myYPosition = turtleViewController.getNode().getTranslateY() * -1;
	}
	
	public Point2D getPosition() {
		return new Point2D(myXPosition, myYPosition);
	}
	
}
