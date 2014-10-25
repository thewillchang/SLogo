package turtle;

import java.io.File;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import transitionstate.TransitionState;
import turtle.draw.MoveTransition;
import turtle.draw.Pen;
import turtle.draw.PenTransition;
import turtle.draw.TurnTransition;

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
	
	public Animation createAnimation(List<TransitionState> states) {
		SequentialTransition sequential = new SequentialTransition();
		for (TransitionState state : states) {
			Transition transition = createTurtleTransition(state);
			sequential.getChildren().add(transition);
		}
		ParallelTransition animation = new ParallelTransition();
		animation.getChildren().add(sequential);
		myTurtleHistory.addHistory(new TurtleHistoryState(animation, myPen.getDrawnLines()));
		myPen.clearDrawnLines();
		return sequential;
	}
	
	private Transition createTurtleTransition(TransitionState state) {
		updateDrawingInfo(state);
		SequentialTransition transition = new SequentialTransition();
		TurnTransition turnTransition = createTurnTransition(state);
		ParallelTransition forwardTransition = createForwardTransition(state);
		transition.getChildren().addAll(turnTransition, forwardTransition);
		return transition;
	}
	
	private void updateDrawingInfo(TransitionState state) {
		myTurtleViewController.updateVisible(state.getVisibleChange());
		myPen.update(state.getPenChange());
	}
	
	private TurnTransition createTurnTransition(TransitionState state) {
		TurnTransition turnTransition = new TurnTransition();
		double rotate = state.getRotateClockwise() - state.getRotateCounterClockwise();
		turnTransition.setTurtle(this);
		turnTransition.setTurn(rotate);
		return turnTransition;
	}
	
	private ParallelTransition createForwardTransition(TransitionState state) {
		ParallelTransition forwardTransition = new ParallelTransition();
		MoveTransition moveTransition = new MoveTransition();
		moveTransition.setTurtle(this);
		moveTransition.setDistance(state.getMove());
		forwardTransition.getChildren().add(moveTransition);
		if (myPen.getPenDown()) {
			PenTransition penTransition = new PenTransition();
			penTransition.setTurtle(this);
			penTransition.setDistance(state.getMove());
			forwardTransition.getChildren().add(penTransition);
		}
		return forwardTransition;
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
