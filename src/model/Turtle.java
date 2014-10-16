package model;

<<<<<<< Updated upstream
import turtle.TurtleModel;
import turtle.TurtleViewController;
=======
>>>>>>> Stashed changes

/**
 * Turtle Object. Contains its own Turtle Model and Turtle View Controllers
 * @author Tanaka Jimha
 *
 */
public class Turtle {
	
	private TurtleModel myTurtleModel;
	private TurtleViewController myTurtleViewController;
	private boolean isSelected;
	
	public Turtle(){
		this.myTurtleModel = new TurtleModel();
		this.myTurtleViewController = new TurtleViewController();
		
	}
	/**
	 * updates the Turtle object's turtle model and in turn the object's turtle view controller
	 */
	public void update() {
		
	}
	
}
