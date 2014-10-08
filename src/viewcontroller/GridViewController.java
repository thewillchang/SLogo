package viewcontroller;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Turtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import transitionstate.TransitionState;
import animation.RotateClockwiseAnimation;
import animation.SLogoAnimation;
import animation.TransitionAnimation;

public class GridViewController implements Observer, ViewController {

	public final static Dimension SIZE = new Dimension(
			TurtleWindowViewController.SIZE.width * 9 / 10, 
			TurtleWindowViewController.SIZE.height * 9 / 10);
	private Group myGrid;
	private List<Turtle> myTurtles;
	private int myCurrentIndex;
	private List<List<Line>> myLines;
	
	public GridViewController() {
		myTurtles = new ArrayList<>();
		myGrid = new Group();
		myGrid.getChildren().add(new Rectangle(SIZE.width, SIZE.height, Color.ALICEBLUE));
		myLines = new LinkedList<List<Line>>();
		
		addTurtle(new Turtle());
		
		
		Button b = new Button();
		b.setText("test");
		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				moveTurtles();
			}
		});
		myGrid.getChildren().add(b);
	}

	public void addTurtle(Turtle turtle) {
		turtle.getPen().attachGrid(myGrid);
		myTurtles.add(turtle);
		myGrid.getChildren().add(turtle.getTurtle());
		turtle.getTurtle().setLayoutX(SIZE.width / 2);
		turtle.getTurtle().setLayoutY(SIZE.height / 2);
	}
	
	private void moveTurtles() {
		TransitionState state = new TransitionState(false, false, 0, 0, 0);
		for (Turtle turtle : myTurtles) {
			SLogoAnimation animation = rotateTurtle(turtle, state);
			animation.linkNextAnimation(moveTurtle(turtle, state));
			animation.startAnimation();
			List<Line> lines = turtle.getPen().getAndClearLines();
			myLines.add(lines);
			for (Line line : lines) {
				if (!myGrid.getChildren().contains(line)) {
					myGrid.getChildren().add(line);
				}
			}
		}
	}
	
	private SLogoAnimation moveTurtle(Turtle turtle, TransitionState transitionState) {
		TransitionAnimation transition = new TransitionAnimation();
		transition.attachInfo(turtle, 100);
		return transition;
	}
	
	private SLogoAnimation rotateTurtle(Turtle turtle, TransitionState transitionState) {
		RotateClockwiseAnimation rotation = new RotateClockwiseAnimation();
		//rotation.attachTurtle(turtleViewController, transitionState);
		rotation.attachInfo(turtle, 45);
		return rotation;
	}
	
	@Override
	public Node getNode() {
		return myGrid;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
