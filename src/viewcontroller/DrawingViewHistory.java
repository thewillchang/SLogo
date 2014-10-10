package viewcontroller;

import java.util.ArrayList;
import java.util.List;

import turtle.Turtle;

public class DrawingViewHistory {

	private List<DrawingViewState> myStates;
	private int myIndex;
	
	public DrawingViewHistory() {
		myStates = new ArrayList<>();
		myIndex = -1;
	}
	
	/**
	 * adds a state of view history to the drawing view history
	 * @param state
	 */
	public void addViewHistory(DrawingViewState state) {
		List<DrawingViewState> states = new ArrayList<>();
		for (int i = 0; i <= myIndex; i++) {
			states.add(myStates.get(i));
		}
		myStates = states;
		myStates.add(state);
		myIndex++;
	}
	
	/**
	 * returns list of lines that were the turtle's last set of moves
	 * to be removed from the view
	 * @param turtle
	 * @return
	 */
	public DrawingViewState undo(Turtle turtle) {
		if (myIndex == -1) {
			return new NullDrawingViewState();
		}
		DrawingViewState state = myStates.get(myIndex);
		myIndex--;
		return state;
	}
	
	/**
	 * returns list of lines that were the turtle's undone set of 
	 * moves to be added to the view
	 * @param turtle
	 * @return
	 */
	public DrawingViewState redo(Turtle turtle) {
		if (myIndex == myStates.size() - 1) {
			return new NullDrawingViewState();
		}
		myIndex++;
		return myStates.get(myIndex);
	}
	
}
