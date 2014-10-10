package turtle;

import javafx.scene.Node;

/**
 * Turtle Object. Contains its own Turtle Model and Turtle View Controllers
 * @author Jonathan Tseng
 * @author Tanaka Jimha
 *
 */
public class Turtle {
	
	private TurtleModel myTurtleModel;
	private TurtleViewController myTurtleViewController;
	private Pen myPen;
	
	public Turtle() {
		myTurtleModel = new TurtleModel();
		myTurtleViewController = new TurtleViewController();
		myPen = new Pen();
	}
	
	public Pen getPen() {
		return myPen;
	}
	
	public Node getTurtle() {
		return myTurtleViewController.getNode();
	}
	
	public double getTurtleRadius() {
		return myTurtleViewController.getRadius();
	}
	
	/**
	 * updates the Turtle object's turtle model and in turn the object's turtle view controller
	 */
	public void update() {

	}
	
}
