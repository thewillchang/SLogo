package turtle;

import java.util.List;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import transitionstate.TransitionState;
import turtle.draw.DrawingViewHistory;
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
	
	private int myId;
	private TurtlePosition myTurtlePosition;
	private TurtleViewController myTurtleViewController;
	private DrawingViewHistory myDrawingViewHistory;
	private Pen myPen;
	private boolean myVisible;
	
	public Turtle() {
		myTurtlePosition = new TurtlePosition();
		myTurtleViewController = new TurtleViewController();
		myPen = new Pen();
		myId = 0;
		myVisible = true;
		myDrawingViewHistory = new DrawingViewHistory();
	}
	
	public Animation update(List<TransitionState> states) {
		SequentialTransition animation = new SequentialTransition();
		for (TransitionState state : states) {
			Transition transition = createTurtleTransition(state);
			animation.getChildren().add(transition);
		}
		return animation;
	}
	
	private Transition createTurtleTransition(TransitionState state) {
		SequentialTransition transition = new SequentialTransition();
		TurnTransition turnTransition = new TurnTransition();
		double rotate = state.getRotateClockwise() - state.getRotateCounterClockwise();
		turnTransition.setTurtle(this);
		turnTransition.setTurn(rotate);
		MoveTransition moveTransition = new MoveTransition();
		moveTransition.setTurtle(this);
		moveTransition.setDistance(state.getMove());
		ParallelTransition forwardTransition = new ParallelTransition();
		forwardTransition.getChildren().addAll(moveTransition);
		if (myPen.getPenDown()) {
			PenTransition penTransition = new PenTransition();
			penTransition.setTurtle(this);
			penTransition.setDistance(state.getMove());
			forwardTransition.getChildren().add(penTransition);
			myPen.drawLine(getTurtle(), penTransition.getLine());
		}
		transition.getChildren().addAll(turnTransition, forwardTransition);
		return transition;
	}
	
	public void updateModel() {
		myTurtlePosition.update(myTurtleViewController);
	}
	
	public void updateVisualState(TransitionState transitionState) {
		myPen.update(transitionState.getPenChange());
		myTurtleViewController.updateVisible(transitionState.getVisibleChange());
	}
	
	/*
	public FullAnimation animate(List<TransitionState> states) {
		FullAnimation animation = new FullAnimation();
		animation.loadAnimation(this, states);
		
		Node turtle = myTurtleViewController.getNode();
		
		Point2D startPosition = new Point2D(turtle.getTranslateX(), turtle.getTranslateY());
		double startRotation = turtle.getRotate();
		animation.attachOnFinish(event -> finishedAnimation(this, startPosition, startRotation));
		
		return animation;
	}
	
	private void finishedAnimation(Turtle turtle, Point2D startPosition, double startRotation) {
		List<Line> lines = turtle.getPen().getAndClearLines();
		Point2D endPosition = new Point2D(turtle.getTurtle().getTranslateX(), turtle.getTurtle().getTranslateY());
		double endRotation = turtle.getTurtle().getRotate();
		myDrawingViewHistory.addViewHistory(new DrawingViewState(startPosition, endPosition, startRotation, endRotation, lines));
		myPen.drawLines(turtle, lines);
	}	
	
	
	public void redo() {
		DrawingViewState state = myDrawingViewHistory.redo(this);
		if (!(state instanceof NullDrawingViewState)) {
			myPen.drawLines(this, state.getLines());
			myTurtleViewController.redoTurtle(this, state);
		}
	}

	public void undo() {
		DrawingViewState state = myDrawingViewHistory.undo(this);
		if (!(state instanceof NullDrawingViewState)) {
			myPen.eraseLines(state.getLines());
			myTurtleViewController.undoTurtle(this, state);
		}
	}*/
	
	public int getId() {
		return myId;
	}
	
	public Pen getPen() {
		return myPen;
	}
	
	public boolean getVisible() {
		return myVisible;
	}
	
	public Node getTurtle() {
		return myTurtleViewController.getNode();
	}
	
	public TurtlePosition getTurtlePosition() {
		return myTurtlePosition;
	}
	
	public double getTurtleRadius() {
		return myTurtleViewController.getRadius();
	}
	
	public boolean isSelected() {
		return myTurtleViewController.isSelected();
	}
	
}
