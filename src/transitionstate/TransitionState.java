package transitionstate;


/**
 * wrapper class for a transition state for the Grid. Specifies how to draw the next path.
 * @author Jonathan Tseng
 * @author Tanaka Jimha
 *
 */
public class TransitionState {

	private PenChange myPenUp;
	private VisibleChange myTurtleVisible;
	private double myMove;
	private double myRotateClockwise;
	private double myRotateCounterClockwise;
	
	public static enum PenChange {
		CHANGE_UP, CHANGE_DOWN, NO_CHANGE
	}
	
	public static enum VisibleChange {
		CHANGE_VISIBLE, CHANGE_INVISIBLE, NO_CHANGE
	}
	
	public TransitionState(PenChange penChange, VisibleChange visibleChange, double distance, double rotateClock, double rotateCounter) {
	    myPenUp = penChange;
	    myTurtleVisible = visibleChange;
	    myMove = distance;
	    myRotateClockwise = rotateClock;
	    myRotateCounterClockwise = rotateCounter;
	}
	
	/**
	 * returns boolean of whether pen is up or down
	 * @return
	 */
	public PenChange getPenUp() {
		return myPenUp;
	}
	
	/**
	 * returns boolean of whether turtle is visible or not
	 * @return
	 */
	public VisibleChange getTurtleVisible() {
		return myTurtleVisible;
	}
	
	/**
         * returns double for how much the turtle moves in the forward direction
         * @return
         */
	public double getMove() {
	    return myMove;
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
