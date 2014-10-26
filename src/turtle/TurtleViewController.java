package turtle;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import viewcontroller.ViewController;
import application.Main;

/**
 * view controller for an individual turtle object
 * 
 * @author Jonathan Tseng
 *
 */
public class TurtleViewController implements ViewController {

	private Group myGroup;
	private final static Dimension mySize = new Dimension(Main.SIZE.width / 40,
			Main.SIZE.width / 40);
	private TurtleImage myTurtleImage;

	public TurtleViewController() {
		TurtleImage.setSize(mySize);
		myTurtleImage = new DefaultTurtleImage();
		myTurtleImage.setSelection(true);
		myGroup = new Group();
		myGroup.getChildren().add(myTurtleImage);
	}

	public boolean isSelected() {
		return myTurtleImage.isSelected();
	}

	public void updateVisible(boolean visible) {
		myTurtleImage.updateVisible(visible);
	}
	
	public void setImage(File file) {
		TurtleImage newTurtleImage;
		try {
			Image image = new Image(new FileInputStream(file), mySize.getHeight(), mySize.getWidth(), false, false);
			newTurtleImage = new UserChosenTurtleImage(image);
			newTurtleImage.setSelection(myTurtleImage.isSelected());
			myGroup.getChildren().remove(myTurtleImage);
			myGroup.getChildren().add(newTurtleImage);
			myTurtleImage = newTurtleImage;
		} catch (FileNotFoundException e) {
			System.out.println("failed: " + e.toString());
			newTurtleImage = new DefaultTurtleImage();
			myGroup.getChildren().remove(myTurtleImage);
			myGroup.getChildren().add(newTurtleImage);
			myTurtleImage = newTurtleImage;
		}
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
		return myGroup;
	}

	@Override
	public void applyTranslations() {
	}

}
