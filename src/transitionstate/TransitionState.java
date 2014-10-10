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
	private double myMove;
	private double myRotateClockwise;
	private double myRotateCounterClockwise;
	
	public TransitionState(boolean penUp, boolean visible, double distance, double rotateClock, double rotateCounter) {
	    myPenUp = penUp;
	    myTurtleVisible = visible;
	    myMove = distance;
	    myRotateClockwise = rotateClock;
	    myRotateCounterClockwise = rotateCounter;
	}
	
	public TransitionState(){
		
	}
	
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
