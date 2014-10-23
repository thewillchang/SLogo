package turtle.draw;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import transitionstate.TransitionState.PenChange;

/**
 * class for creating paths drawn
 * @author Jonathan Tseng
 *
 */
public class Pen {

	// default pen values
	private static double ourDefaultWidth = 3;
	private static Color ourDefaultColor = Color.BLACK;
	
	private Color myColor;
	private double myWidth;
	private Group myGrid;
	private boolean myPenDown;
	private Node myTurtleNode;
	
	private List<Line> myDrawnLines;
	
	public Pen(Node turtle) {
		this(turtle, ourDefaultColor, ourDefaultWidth);
	}
	
	public Pen(Node turtle, Color color, double width) {
		myTurtleNode = turtle;
		myColor = ourDefaultColor;
		myWidth = ourDefaultWidth;
		myPenDown = true;
		myDrawnLines = new ArrayList<>();
	}
	
	public Color getColor() {
		return myColor;
	}
	
	public double getWidth() {
		return myWidth;
	}
	
	/**
	 * attaches the grid on which the pen is drawing
	 * @param grid
	 */
	public void attachGrid(Group grid) {
		myGrid = grid;
	}
	
	public void drawLine(Line line) {
		myGrid.getChildren().remove(myTurtleNode);
		myGrid.getChildren().add(line);
		myGrid.getChildren().add(myTurtleNode);
		myDrawnLines.add(line);
	}
	
	public List<Line> getDrawnLines() {
		return myDrawnLines;
	}
	
	public void clearDrawnLines() {
		myDrawnLines.clear();
	}
	
	public void update(PenChange penChange) {
		if (penChange.equals(PenChange.CHANGE_DOWN)) {
			myPenDown = true;
		} else if (penChange.equals(PenChange.CHANGE_UP)) {
			myPenDown = false;
		}
	}
	
	public boolean getPenDown() {
		return myPenDown;
	}
	
}