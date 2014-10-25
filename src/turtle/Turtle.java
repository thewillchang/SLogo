package turtle;

import java.io.File;
import java.util.List;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import transitionstate.TransitionState;
import turtle.draw.Pen;
import turtle.draw.TransitionFactory;

/**
 * Turtle Object. Contains its own Turtle Model and Turtle View Controllers
 * @author Jonathan Tseng
 * @author Tanaka Jimha
 *
 */
public class Turtle {
	
	private static int ourTurtleCount = 0;
	private int myId;
	private TurtleViewController myTurtleViewController;
	private Pen myPen;
	private TurtleHistory myTurtleHistory;
	
	public Turtle() {
		myTurtleViewController = new TurtleViewController();
		myPen = new Pen(getTurtle());
		myId = ourTurtleCount;
		ourTurtleCount++;
		myTurtleHistory = new TurtleHistory();
	}
	
	public Transition createAnimation(List<TransitionState> states) {
		ParallelTransition animation = new TransitionFactory().createAnimation(this, states);
		myTurtleHistory.addHistory(new TurtleHistoryState(animation, myPen.getDrawnLines()));
		myPen.clearDrawnLines();
		return animation;
	}
	
	public void updateVisualState(TransitionState transitionState) {	
		myPen.update(transitionState.getPenChange());
		myTurtleViewController.updateVisible(transitionState.getVisibleChange());
	}

	public TurtleHistoryState redo() {
		return myTurtleHistory.redo();
	}

	public TurtleHistoryState undo() {
		return myTurtleHistory.undo();
	}
	
	public int getId() {
		return myId;
	}
	
	public Pen getPen() {
		return myPen;
	}
	
	public void setImage(File file) {
		myTurtleViewController.setImage(file);
	}
	
	public Node getTurtle() {
		return myTurtleViewController.getNode();
	}
	
	public double getTurtleRadius() {
		return myTurtleViewController.getRadius();
	}
	
	public boolean isSelected() {
		return myTurtleViewController.isSelected();
	}
	
}
