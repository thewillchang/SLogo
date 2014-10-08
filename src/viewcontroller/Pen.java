package viewcontroller;

import java.util.ArrayList;
import java.util.List;

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

	private Line myLine;
	private List<Line> myLines;
	private Color myColor;
	private double myWidth;
	private Group myGrid;
	
	public Pen() {
		myColor = Color.BLACK;
		myWidth = 5;
		myLines = new ArrayList<>();
		myLine = new Line();
	}
	
	public void attachGrid(Group grid) {
		myGrid = grid;
	}
	
	public List<Line> getAndClearLines() {
		List<Line> lines = new ArrayList<Line>(myLines);
		myLines.clear();
		return lines;
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
	
	public void erase() {
		myGrid.getChildren().remove(myLine);
	}
	
	public void finishLine() {
		myLines.add(myLine);
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
