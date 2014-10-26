package viewcontroller.turtlegrid;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.ParallelTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
 */
public class GridViewController implements ViewController, MainModelObserver {

	private final static String FORWARD_KEY = "Forward";
	private final static String RIGHT_KEY = "Right";
	private final static double KEY_FORWARD_VALUE = 25;
	private final static double KEY_RIGHT_VALUE = 15;
	
	public final static Dimension SIZE = new Dimension(
			TurtleWindowViewController.SIZE.width * 12 / 10, 
			TurtleWindowViewController.SIZE.height * 8 / 10);
	
	private TurtleWindowViewController myParent;
	private GridLines myGridLines;
	private boolean myResizeGrid;
	private Group myGrid;
	private Rectangle myGridBackground;
	private List<Turtle> myTurtles;
	
	public GridViewController(TurtleWindowViewController parent) {
		myParent = parent;
		myTurtles = new ArrayList<>();
		myGrid = new Group();
		setUpGridKeyListeners();
		createBackground();
		myResizeGrid = true;
	}
	
	private void setUpGridKeyListeners() {
		myGrid.setOnMouseClicked(event->myGrid.requestFocus());
		myGrid.setOnKeyPressed(event->listenKeys(event));
	}
	
	private void listenKeys(KeyEvent event) {
		if (event.getCode().equals(KeyCode.UP) || event.getCode().equals(KeyCode.DOWN)) {
			forwardKeyPressed(event.getCode().equals(KeyCode.UP));
		} else if (event.getCode().equals(KeyCode.LEFT) || event.getCode().equals(KeyCode.RIGHT)) {
			rightKeyPressed(event.getCode().equals(KeyCode.RIGHT));
		}
	}
	
	private void forwardKeyPressed(boolean forward) {
		double distance = ((forward) ? 1 : -1) * KEY_FORWARD_VALUE;
		myParent.passSLogoCommand(FORWARD_KEY, Double.toString(distance));
	}
	
	private void rightKeyPressed(boolean clockwise) {
		double degrees = ((clockwise) ? 1 : -1) * KEY_RIGHT_VALUE;
		myParent.passSLogoCommand(RIGHT_KEY, Double.toString(degrees));
	}

	private void createBackground() {
		Rectangle background = new Rectangle(SIZE.width, SIZE.height, View.BACKGROUND_COLOR);
		myGridBackground = new Rectangle(SIZE.width, SIZE.height);
		myGridLines = new GridLines(myGridBackground.getHeight(), myGridBackground.getWidth());
		myGrid.getChildren().addAll(background, myGridBackground, myGridLines);
	}
	
	private void setBackgroundColor(Color color) {
		myGridBackground.setFill(color);
	}
	
	@Override
	public Node getNode() {
		return myGrid;
	}

	@Override
	public void update(MainModel model) {
		setBackgroundColor(model.getBackgroundColor());
		if (model.isTurtleAdded()) {
			updateTurtles(model.getTurtles());
		} else if (!model.failedParse()) {
			moveTurtles(model.getAnimation());
		}	
	}
	
	public void toggleGridLines() {
		myGridLines.toggle();
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
			if (myResizeGrid) {
				fixGridBackground(turtle.getTurtleRadius()); 
				myResizeGrid = false;
			}
		}
	}
	
	private void fixGridBackground(double pad) {
		double padding = pad * 19 / 20;
		myGridBackground.setWidth(SIZE.width - padding * 2);
		myGridBackground.setHeight(SIZE.height - padding * 2);
		myGridBackground.setTranslateX(padding);
		myGridBackground.setTranslateY(padding);
	
		myGridLines.changeSize(myGridBackground.getHeight(), myGridBackground.getWidth());
		myGridLines.setTranslateX(padding);
		myGridLines.setTranslateY(padding);
	}
	
	private void moveTurtles(ParallelTransition animation) {
		for (Turtle turtle : myTurtles) {
			myGrid.getChildren().remove(turtle.getTurtle());
		}
		for (Turtle turtle : myTurtles) {
			myGrid.getChildren().add(turtle.getTurtle());
		}
		animation.play();
	}

	@Override
	public void applyTranslations() {		
	}
	
}
