package turtle;

import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

public class DrawingViewState {

	private Point2D myStartPosition;
	private Point2D myEndPosition;
	private double myStartRotation;
	private double myEndRotation;
	private List<Line> myLines;
	
	public DrawingViewState(Point2D startPosition, Point2D endPosition,
			double startRotation, double endRotation, List<Line> lines) {
		myStartPosition = startPosition;
		myEndPosition = endPosition;
		myStartRotation = startRotation;
		myEndRotation = endRotation;
		myLines = lines;
	}
	
	/**
	 * returns a turtle's start position for this state
	 * @return
	 */
	public Point2D getStartPosition() {
		return myStartPosition;	
	}
	
	/**
	 * returns the turtle's end position for this state
	 * @return
	 */
	public Point2D getEndPosition() {
		return myEndPosition;
	}

	/**
	 * returns the list of lines that are added for this state
	 * @return
	 */
	public List<Line> getLines() {
		return myLines;
	}

	/**
	 * returns the turtle's start rotation for this state
	 * @return
	 */
	public double getStartRotation() {
		return myStartRotation;
	}
	
	/**
	 * returns the turtle's end rotation for this state
	 * @return
	 */
	public double getEndRotation() {
		return myEndRotation;
	}
	
}
