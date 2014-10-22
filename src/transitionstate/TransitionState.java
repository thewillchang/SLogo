package transitionstate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


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
	private Set<Integer> myTurtleIDs;
	
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
	    myTurtleIDs = new HashSet<>();
	}
	
	public void setTurtles(Collection<Integer> turtleIDs) {
		myTurtleIDs.addAll(turtleIDs);
	}
	
	public Collection<Integer> getTurtles() {
		return myTurtleIDs;
	}
	
	/**
	 * returns boolean of whether pen is up or down
	 * @return
	 */
	public PenChange getPenChange() {
		return myPenUp;
	}
	
	/**
	 * returns boolean of whether turtle is visible or not
	 * @return
	 */
	public VisibleChange getVisibleChange() {
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
