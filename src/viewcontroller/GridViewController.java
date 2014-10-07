package viewcontroller;

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
import javafx.scene.paint.Color;
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
	private List<TurtleViewController> myTurtles;
	
	public GridViewController() {
		myTurtles = new ArrayList<>();
		myGrid = new Group();
		myGrid.getChildren().add(new Rectangle(SIZE.width, SIZE.height, Color.ALICEBLUE));
		addTurtle();
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

	public void addTurtle() {
		TurtleViewController turtle = new TurtleViewController();
		myTurtles.add(turtle);
		myGrid.getChildren().add(turtle.getNode());
		turtle.getNode().setLayoutX(SIZE.width / 2);
		turtle.getNode().setLayoutY(SIZE.height / 2);
	}
	
	private void moveTurtles() {
		TransitionState state = new TransitionState(false, false, 0, 0, 0);
		for (TurtleViewController turtleViewController : myTurtles) {
			SLogoAnimation animation = rotateTurtle(turtleViewController, state);
			animation.linkNextAnimation(moveTurtle(turtleViewController, state));
			animation.startAnimation();
		}
	}
	
	private SLogoAnimation moveTurtle(TurtleViewController turtleViewController, TransitionState transitionState) {
		TransitionAnimation transition = new TransitionAnimation();
		transition.attachInfo(turtleViewController, 100);
		return transition;
	}
	
	private SLogoAnimation rotateTurtle(TurtleViewController turtleViewController, TransitionState transitionState) {
		RotateClockwiseAnimation rotation = new RotateClockwiseAnimation();
		//rotation.attachTurtle(turtleViewController, transitionState);
		rotation.attachInfo(turtleViewController, 90);
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
