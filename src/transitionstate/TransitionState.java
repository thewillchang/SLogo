package transitionstate;

/**
 * wrapper class for a transition state for the Grid. Specifies how to draw the next path.
 * @author Jonathan Tseng
 * @author Tanaka Jimha
 *
 */
public class TransitionState {

	private boolean myPenUp;
	private boolean myTurtleVisible;
	private double myXMove;
	private double myYMove;
	private double myRotateClockwise;
	private double myRotateCounterClockwise;
	
	/**
	 * returns boolean of whether pen is up or down
	 * @return
	 */
	public boolean getPenUp() {
		return myPenUp;
	}
	
	/**
	 * returns boolean of whether turtle is visible or not
	 * @return
	 */
	public boolean getTurtleVisible() {
		return myTurtleVisible;
	}
	
	/**
	 * returns double for how much the turtle moves in the X direction
	 * @return
	 */
	public double getXMove() {
		return myXMove;
	}
	
	/** 
	 * returns double for how much the turtle moves in the Y direction
	 * @return
	 */
	public double getYMove() {
		return myYMove;
	}
	
	/**
	 * gets the turtle's clockwise rotation
	 * @return
	 */
	public double getRotateClockwise() {
		return myRotateClockwise;
	}
	
	/**
	 * gets the turtle's counterclockwise rotation
	 * @return
	 */
	public double getRotateCounterClockwise() {
		return myRotateCounterClockwise;
	}
	
}
