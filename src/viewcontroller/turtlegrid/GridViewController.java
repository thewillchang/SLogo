package viewcontroller.turtlegrid;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import transitionstate.TransitionState;
import turtle.Turtle;
import turtle.animation.FullAnimation;
import turtle.animation.ParallelAnimations;
import viewcontroller.ViewController;

public class GridViewController implements ViewController {

	public final static Dimension SIZE = new Dimension(
			TurtleWindowViewController.SIZE.width * 12 / 10, 
			TurtleWindowViewController.SIZE.height * 9 / 10);
	private Group myGrid;
	private List<Turtle> myTurtles;
	
	private Button b;
	
	public GridViewController() {
		myTurtles = new ArrayList<>();
		myGrid = new Group();
		Rectangle background = new Rectangle(SIZE.width, SIZE.height, Color.web("#000099"));
		myGrid.getChildren().add(background);
		
		addTurtle(new Turtle());
		addTurtle(new Turtle());
		addTurtle(new Turtle());
		
		b = new Button();
		b.setText("test");
		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				moveTurtles();
				b.setDisable(true);
			}
		});
		myGrid.getChildren().add(b);
	}
	
	public void redo() {
		for (Turtle turtle : myTurtles) {
			turtle.redo();
		}
	}

	public void undo() {
		for (Turtle turtle : myTurtles) {
			turtle.undo();
		}
	}
	
	public void addTurtle(Turtle turtle) {
		turtle.getPen().attachGrid(myGrid);
		myTurtles.add(turtle);
		myGrid.getChildren().add(turtle.getTurtle());
		turtle.getTurtle().setLayoutX(SIZE.width / 2);
		turtle.getTurtle().setLayoutY(SIZE.height / 2);
	}
	
	private void moveTurtles() {
		List<FullAnimation> animations = new ArrayList<>();
		for (Turtle turtle : myTurtles) {
			List<TransitionState> states = new ArrayList<>();
			for (int i = 0; i < 4; i ++) states.add(new TransitionState(false, true, 100 + Math.random() * 100, Math.random() * 180, Math.random() * 180));
			
			FullAnimation animation = turtle.animate(states);
			animations.add(animation);
		}
		ParallelAnimations parallelAnimations = new ParallelAnimations();
		parallelAnimations.loadAnimations(animations);
		parallelAnimations.attachOnFinished(event -> enableButtons());
		parallelAnimations.playParallelAnimations();
	}
	
	private void enableButtons() {
		b.setDisable(false);
	}
	
	@Override
	public Node getNode() {
		return myGrid;
	}

}
