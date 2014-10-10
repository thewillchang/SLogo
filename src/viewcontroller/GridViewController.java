package viewcontroller;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import transitionstate.TransitionState;
import turtle.Turtle;
import turtle.animation.RotateClockwiseAnimation;
import turtle.animation.SLogoAnimation;
import turtle.animation.TransitionAnimation;

public class GridViewController implements Observer, ViewController {

	public final static Dimension SIZE = new Dimension(
			TurtleWindowViewController.SIZE.width * 9 / 10, 
			TurtleWindowViewController.SIZE.height * 9 / 10);
	private Group myGrid;
	private List<Turtle> myTurtles;
	
	private DrawingViewHistory myDrawingViewHistory; 
	
	private Button b;
	private Button undo;
	private Button redo; 
	
	public GridViewController() {
		myTurtles = new ArrayList<>();
		myDrawingViewHistory  = new DrawingViewHistory();
		myGrid = new Group();
		myGrid.getChildren().add(new Rectangle(SIZE.width, SIZE.height, Color.ALICEBLUE));
		
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
			DrawingViewState state = myDrawingViewHistory.redo(turtle);
			if (!(state instanceof NullDrawingViewState)) {
				drawLines(turtle, state.getLines());
				redoTurtle(turtle, state);
			}
		}
	}

	public void undo() {
		for (Turtle turtle : myTurtles) {
			DrawingViewState state = myDrawingViewHistory.undo(turtle);
			if (!(state instanceof NullDrawingViewState)) {
				eraseLines(state.getLines());
				undoTurtle(turtle, state);
			}
		}
	}
	
	public void addTurtle(Turtle turtle) {
		turtle.getPen().attachGrid(myGrid);
		myTurtles.add(turtle);
		myGrid.getChildren().add(turtle.getTurtle());
		turtle.getTurtle().setLayoutX(SIZE.width / 2);
		turtle.getTurtle().setLayoutY(SIZE.height / 2);
	}
	
	private void animateTurtle(Turtle turtle, List<TransitionState> states) {
		SLogoAnimation animation = rotateTurtle(turtle, states.get(0));
		SLogoAnimation currentAnimation = walkTurtle(turtle, states.get(0));
		animation.linkNextAnimation(currentAnimation);
		SLogoAnimation nextAnimation;
		for (TransitionState state : states.subList(1, states.size())) {
			nextAnimation = rotateTurtle(turtle, state);
			currentAnimation.linkNextAnimation(nextAnimation);
			currentAnimation = nextAnimation;
			nextAnimation = walkTurtle(turtle, state);
			currentAnimation.linkNextAnimation(nextAnimation);
			currentAnimation = nextAnimation;
		}
		Point2D position = new Point2D(turtle.getTurtle().getTranslateX(), 
				turtle.getTurtle().getTranslateY());
		double rotation = turtle.getTurtle().getRotate();
		currentAnimation.attachOnFinish(event -> finishedAnimation(turtle, position, rotation));
		animation.startAnimation();
	}
	
	private void moveTurtles() {
		List<TransitionState> states = new ArrayList<>();
		for (int i = 0; i < 4; i ++) states.add(new TransitionState(false, true, 200, 110, 0));
		for (Turtle turtle : myTurtles) {
			//moveTurtle(turtle, new TransitionState(false, true, 200, 110, 0));
			animateTurtle(turtle, states);
		}
	}
	
	private void finishedAnimation(Turtle turtle, Point2D startPosition, double startRotation) {
		List<Line> lines = turtle.getPen().getAndClearLines();
		Point2D endPosition = new Point2D(turtle.getTurtle().getTranslateX(), turtle.getTurtle().getTranslateY());
		double endRotation = turtle.getTurtle().getRotate();
		myDrawingViewHistory.addViewHistory(turtle, new DrawingViewState(startPosition, endPosition, startRotation, endRotation, lines));
		drawLines(turtle, lines);
		enableButtons();
	}
	
	private void enableButtons() {
		b.setDisable(false);
		undo.setDisable(false);
		redo.setDisable(false);
	}
	
	private void drawLines(Turtle turtle, List<Line> lines) {
		myGrid.getChildren().remove(turtle.getTurtle());
		for (Line line : lines) {
			if (!myGrid.getChildren().contains(line)) {
				myGrid.getChildren().add(line);
			}
		}
		myGrid.getChildren().add(turtle.getTurtle());
	}
	
	private void eraseLines(List<Line> lines) {
		for (Line line : lines) {
			if (myGrid.getChildren().contains(line)) {
				myGrid.getChildren().remove(line);
			}
		}
	}
	
	private SLogoAnimation walkTurtle(Turtle turtle, TransitionState transitionState) {
		TransitionAnimation transition = new TransitionAnimation();
		transition.attachTurtle(turtle, transitionState);
		return transition;
	}
	
	private SLogoAnimation rotateTurtle(Turtle turtle, TransitionState transitionState) {
		RotateClockwiseAnimation rotation = new RotateClockwiseAnimation();
		rotation.attachTurtle(turtle, transitionState);
		return rotation;
	}
	
	private void undoTurtle(Turtle turtle, DrawingViewState state) {
		turtle.getTurtle().setTranslateX(state.getStartPosition().getX());
		turtle.getTurtle().setTranslateY(state.getStartPosition().getY());
		turtle.getTurtle().setRotate(state.getStartRotation());
	}
	
	private void redoTurtle(Turtle turtle, DrawingViewState state) {
		turtle.getTurtle().setTranslateX(state.getEndPosition().getX());
		turtle.getTurtle().setTranslateY(state.getEndPosition().getY());
		turtle.getTurtle().setRotate(state.getEndRotation());
	}
	
	@Override
	public Node getNode() {
		return myGrid;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
