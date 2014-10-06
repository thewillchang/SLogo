package viewcontroller;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import application.Main;

/**
 * view controller for an individual turtle object
 * @author Jonathan Tseng
 *
 */
public class TurtleViewController implements Observer, ViewController {

	private Group myTurtle;
	private Dimension mySize = new Dimension(Main.SIZE.width / 20, Main.SIZE.width / 20);
	private List<Shape> myTurtleBodyParts; 
	
	public TurtleViewController() {
		myTurtle = new Group();
		createTurtle();
	}
	
	private void createTurtle() {
		myTurtleBodyParts = new ArrayList<Shape>();
		Circle body = new Circle(mySize.height);
		
		
	}
	
	
	
	@Override
	public Node getNode() {
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
