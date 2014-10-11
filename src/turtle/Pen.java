package turtle;

import java.util.ArrayList;
import java.util.List;

import viewcontroller.turtlegrid.GridViewController;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

/**
 * class for creating paths drawn
 * @author Jonathan Tseng
 *
 */
public class Pen {

	// default pen values
	private static double ourDefaultWidth = 3;
	private static Color ourDefaultColor = Color.BLACK;
	
	private Line myLine;
	private List<Line> myLines;
	private Color myColor;
	private double myWidth;
	private Group myGrid;
	
	public Pen() {
		this(ourDefaultColor, ourDefaultWidth);
	}
	
	public Pen(Color color, double width) {
		myColor = color;
		myWidth = width;
		myLines = new ArrayList<>();
		myLine = new Line();
	}
	
	/**
	 * attaches the grid on which the pen is drawing
	 * @param grid
	 */
	public void attachGrid(Group grid) {
		myGrid = grid;
	}
	
	/**
	 * gets and clears the list of recently drawn lines 
	 * @return
	 */
	public List<Line> getAndClearLines() {
		List<Line> lines = new ArrayList<Line>(myLines);
		myLines.clear();
		return lines;
	}
	
	public void drawLines(Turtle turtle, List<Line> lines) {
		myGrid.getChildren().remove(turtle.getTurtle());
		for (Line line : lines) {
			if (!myGrid.getChildren().contains(line)) {
				myGrid.getChildren().add(line);
			}
		}
		myGrid.getChildren().add(turtle.getTurtle());
	}
	
	public void eraseLines(List<Line> lines) {
		for (Line line : lines) {
			if (myGrid.getChildren().contains(line)) {
				myGrid.getChildren().remove(line);
			}
		}
	}
	
	/**
	 * creates a drawn path to place on the canvas
	 * @return
	 */
	public void drawLine(Point2D start, Point2D end, boolean penDown, Node turtle) {
		myLine = new Line(0, 0, end.getX() - start.getX(), end.getY() - start.getY());
		myLine.setStroke(myColor);
		myLine.setVisible(penDown);
		myLine.setStrokeWidth(myWidth);
		myLine.setStrokeLineCap(StrokeLineCap.ROUND);
		myGrid.getChildren().remove(turtle);
		myGrid.getChildren().add(myLine);
		myGrid.getChildren().add(turtle);
		myLine.setTranslateX(start.getX() + GridViewController.SIZE.width / 2);
		myLine.setTranslateY(start.getY() + GridViewController.SIZE.height / 2);
	}
	
	/**
	 * erases a line from the grid
	 */
	public void erase() {
		myGrid.getChildren().remove(myLine);
	}
	
	/**
	 * finalizes a line by adding it to the current list of drawn lines
	 */
	public void finishLine() {
		myLines.add(myLine);
		myLine = new Line();
	}
	
	/**
	 * sets the width of the pen stroke
	 * @param width
	 */
	public void setWidth(double width) {
		myWidth = width;
	}

	/**
	 * sets the color of the pen
	 * @param color
	 */
	public void setColor(Color color) {
		myColor = color;
	}
	
}