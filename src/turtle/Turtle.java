package turtle;

import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Line;
import transitionstate.TransitionState;
import turtle.animation.FullAnimation;
import viewcontroller.DrawingViewHistory;
import viewcontroller.DrawingViewState;
import viewcontroller.NullDrawingViewState;

/**
 * Turtle Object. Contains its own Turtle Model and Turtle View Controllers
 * @author Jonathan Tseng
 * @author Tanaka Jimha
 *
 */
public class Turtle {
	
	private int id;
	private TurtleModel myTurtleModel;
	private TurtleViewController myTurtleViewController;
	private Pen myPen;
	private DrawingViewHistory myDrawingViewHistory;  
	
	public Turtle() {
		myTurtleModel = new TurtleModel();
		myTurtleViewController = new TurtleViewController();
		myPen = new Pen();
		id = 0;
		myDrawingViewHistory  = new DrawingViewHistory();
	}
	
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
		myDrawingViewHistory.addViewHistory(turtle, new DrawingViewState(startPosition, endPosition, startRotation, endRotation, lines));
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
	}
	
	public Pen getPen() {
		return myPen;
	}
	
	public Node getTurtle() {
		return myTurtleViewController.getNode();
	}
	
	public double getTurtleRadius() {
		return myTurtleViewController.getRadius();
	}
	
	/**
	 * updates the Turtle object's turtle model and in turn the object's turtle view controller
	 */
	public void update() {

	}
	
}
