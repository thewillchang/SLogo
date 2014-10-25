package turtle;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.Main;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import transitionstate.TransitionState.VisibleChange;
import viewcontroller.ViewController;

/**
 * view controller for an individual turtle object
 * 
 * @author Jonathan Tseng
 *
 */
public class TurtleViewController implements ViewController {

	private final static Dimension mySize = new Dimension(Main.SIZE.width / 40,
			Main.SIZE.width / 40);
	private TurtleImage myTurtleImage;

	public TurtleViewController() {
		TurtleImage.setSize(mySize);
		myTurtleImage = new DefaultTurtleImage();
	}

	public boolean isSelected() {
		return myTurtleImage.isSelected();
	}

	public void updateVisible(VisibleChange visibleChange) {
		myTurtleImage.updateVisible(visibleChange);
	}
	
	public void setImage(File file) {
		System.out.println("reached");
		try {
			Image image = new Image(new FileInputStream(file), mySize.getHeight(), mySize.getWidth(), false, false);
			myTurtleImage = new UserChosenTurtleImage(image);
		} catch (FileNotFoundException e) {
			System.out.println("failed: " + e.toString());
		}
	}

	/**
	 * colors the entire turtle
	 * 
	 * @param color
	 */
	public void colorTurtle(Color color) {
		myTurtleImage.colorTurtle(color);
	}

	/**
	 * gets the radius of the turtle
	 * 
	 * @return
	 */
	public double getRadius() {
		return myTurtleImage.getRadius();
	}

	@Override
	public Node getNode() {
		return myTurtleImage;
	}

	@Override
	public void applyTranslations() {
	}

}
