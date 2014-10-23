package transitionstate;

import javafx.scene.paint.Color;
import turtle.TurtlePosition;

public class TurtleState {

	private TurtlePosition myTurtlePosition;
	private boolean myVisible;
	private boolean myPenDown;
	private Color myPenColor;
	private double myPenWidth;
	
	public TurtleState(TurtlePosition turtlePosition,
			boolean visible, boolean penDown, Color color,
			double width) {
		myTurtlePosition = turtlePosition;
		myVisible = visible;
		myPenDown = penDown;
		myPenColor = color;
		myPenWidth = width;
	}

}
