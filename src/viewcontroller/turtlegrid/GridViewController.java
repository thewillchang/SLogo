package viewcontroller.turtlegrid;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import transitionstate.TransitionState;
import turtle.Turtle;
import turtle.animation.FullAnimation;
import turtle.animation.ParallelAnimations;
import viewcontroller.ViewController;

public class GridViewController implements Observer, ViewController {

	public final static Dimension SIZE = new Dimension(
			TurtleWindowViewController.SIZE.width * 9 / 10, 
			TurtleWindowViewController.SIZE.height * 9 / 10);
	private Group myGrid;
	private List<Turtle> myTurtles;
	
	private Button b;
	private Button undo;
	private Button redo; 
	
	public GridViewController() {
		myTurtles = new ArrayList<>();
		myGrid = new Group();
		myGrid.getChildren().add(new Rectangle(SIZE.width, SIZE.height, Color.ALICEBLUE));
		
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
				redo.setDisable(true);
				undo.setDisable(true);
			}
		});
		
		redo = new Button();
		redo.setText("redo");
		redo.setOnAction(event -> redo());
		
		undo = new Button();
		undo.setText("undo");
		undo.setOnAction(event -> undo());
		HBox box = new HBox();
		box.getChildren().addAll(b, undo, redo);
		myGrid.getChildren().add(box);
	}
	
	private void redo() {
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
		undo.setDisable(false);
		redo.setDisable(false);
	}
	
	@Override
	public Node getNode() {
		return myGrid;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
