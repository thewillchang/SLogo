package viewcontroller.turtlegrid;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.MainModel;
import transitionstate.TransitionState;
import transitionstate.TransitionState.PenChange;
import transitionstate.TransitionState.VisibleChange;
import turtle.Turtle;
import viewcontroller.MainModelObserver;
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
	private List<Turtle> myTurtles;
	
	private ParallelTransition myAnimation;
	
	private Button b;
	
	public GridViewController() {
		myTurtles = new ArrayList<>();
		myGrid = new Group();
		setBackground();
		
		b = new Button();
		b.setText("test");
		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				moveTurtles();
				b.setDisable(true);
			}
		});
		
		Button c = new Button();
		c.setTranslateX(100);
		c.setText("what");
		c.setOnAction(event->slow());
		
		myGrid.getChildren().addAll(b, c);
	}
	
	private void slow() {
		myAnimation.setRate(Math.abs(myAnimation.getRate()) * 1.5);
		//myAnimation.play();
	}
	
	private void setBackground() {
		Rectangle background = new Rectangle(SIZE.width, SIZE.height, Color.web("#000099"));
		myGrid.getChildren().add(background);
	}
	
	public void redo() {
		for (Turtle turtle : myTurtles) {
			//turtle.redo();
		}
	}

	public void undo() {
		for (Turtle turtle : myTurtles) {
			//turtle.undo();
		}
	}
	
	private void enableButtons() {
		b.setDisable(false);
	}
	
	@Override
	public Node getNode() {
		return myGrid;
	}

	@Override
	public void update(MainModel model) {
		if (model.isTurtleAdded()) {
			updateTurtles(model.getTurtles());
		} else {
			if (!model.getResult().getHasError()) {
				moveTurtles(model.getTurtleTransitionMapping());
			}
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
		}
	}
	
	private void moveTurtles(Map<Turtle, List<TransitionState>> mapping) {
		myAnimation = new ParallelTransition();
		for (Turtle turtle : mapping.keySet()) {
			Animation animation = turtle.update(mapping.get(turtle));
			myAnimation.getChildren().add(animation);
		}
		myAnimation.setOnFinished(event->enableButtons());
		myAnimation.play();
	}
	
	private void moveTurtles() {
		List<TransitionState> states = new ArrayList<>();
		for (int i = 0; i < 1; i ++) {
			TransitionState state = new TransitionState(PenChange.CHANGE_DOWN, VisibleChange.CHANGE_VISIBLE, 100, 45, 0);
			states.add(state);
		}
		
		for (Turtle turtle : myTurtles) {
			Animation anim;
			anim = turtle.update(states);
			anim.setOnFinished(event->enableButtons());
			anim.play();
		}
	}

}
