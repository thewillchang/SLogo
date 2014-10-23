package viewcontroller.turtlegrid;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.MainModel;
import turtle.Turtle;
import viewcontroller.MainModelObserver;
import viewcontroller.View;
import viewcontroller.ViewController;

/**
 * View Controller for Grid view that has the turtles
 * @author Jonathan Tseng
 *
 */
public class GridViewController implements ViewController, MainModelObserver {

	public final static Dimension SIZE = new Dimension(
			TurtleWindowViewController.SIZE.width * 12 / 10, 
			TurtleWindowViewController.SIZE.height * 9 / 10);
	private Group myGrid;
	private Rectangle myGridBackground;
	private List<Turtle> myTurtles;
	
	public GridViewController() {
		myTurtles = new ArrayList<>();
		myGrid = new Group();
		setBackground();
	}
	
	private void setBackground() {
		Rectangle background = new Rectangle(SIZE.width, SIZE.height, View.BACKGROUND_COLOR);
		myGridBackground = new Rectangle(SIZE.width, SIZE.height, Color.web("#000099"));
		myGrid.getChildren().addAll(background, myGridBackground);
	}
	
	@Override
	public Node getNode() {
		return myGrid;
	}

	@Override
	public void update(MainModel model) {
		if (model.isTurtleAdded()) {
			updateTurtles(model.getTurtles());
		} else if (!model.failedParse()) {
			moveTurtles(model.getAnimation());
		}	
	}
	
	private void updateTurtles(List<Turtle> turtles) {
		for (Turtle turtle : turtles) {
			if (!myTurtles.contains(turtle)) {
				myTurtles.add(turtle);
				turtle.getPen().attachGrid(myGrid);
				myGrid.getChildren().add(turtle.getTurtle());
				turtle.getTurtle().setTranslateX(turtle.getTurtle().getTranslateX() + SIZE.width / 2);
				turtle.getTurtle().setTranslateY(turtle.getTurtle().getTranslateY() + SIZE.height / 2);
			}
			fixGridBackground(turtle.getTurtleRadius());
		}
	}
	
	private void fixGridBackground(double pad) {
		double padding = pad * 19 / 20;
		myGridBackground.setWidth(SIZE.width - padding * 2);
		myGridBackground.setHeight(SIZE.height - padding * 2);
		myGridBackground.setTranslateX(padding);
		myGridBackground.setTranslateY(padding);
	}
	
	private void moveTurtles(Animation animation) {
		//TODO setOnFinish reenable view
		animation.play();
	}
	
}
