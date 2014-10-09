package viewcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Turtle;

public class DrawingViewHistory {

	private Map<Turtle, List<DrawingViewState>> myTurtleStates;
	private Map<Turtle, Integer> myTurtleIndices;
	
	public DrawingViewHistory() {
		myTurtleIndices = new HashMap<>();
		myTurtleStates = new HashMap<>();
	}
	
	public void addViewHistory(Turtle turtle, DrawingViewState state) {
		if (!myTurtleIndices.containsKey(turtle)) {
			myTurtleIndices.put(turtle, -1);
			myTurtleStates.put(turtle, new LinkedList<DrawingViewState>());
		} else {
			List<DrawingViewState> states = new ArrayList<>();
			for (int i = 0; i <= myTurtleIndices.get(turtle); i++) {
				states.add(myTurtleStates.get(turtle).get(i));
			}
			myTurtleStates.put(turtle, states);
		}
		myTurtleStates.get(turtle).add(state);
		myTurtleIndices.put(turtle, myTurtleIndices.get(turtle) + 1);
	}
	
	/**
	 * returns list of lines that were the turtle's last set of moves
	 * to be removed from the view
	 * @param turtle
	 * @return
	 */
	public DrawingViewState undo(Turtle turtle) {
		if (!myTurtleIndices.containsKey(turtle) || 
				myTurtleIndices.get(turtle) == -1) {
			return new NullDrawingViewState();
		}
		DrawingViewState state = myTurtleStates.get(turtle).get(myTurtleIndices.get(turtle));
		myTurtleIndices.put(turtle, myTurtleIndices.get(turtle)- 1);
		return state;
	}
	
	/**
	 * returns list of lines that were the turtle's undone set of 
	 * moves to be added to the view
	 * @param turtle
	 * @return
	 */
	public DrawingViewState redo(Turtle turtle) {
		if (!myTurtleIndices.containsKey(turtle) || 
				!myTurtleStates.containsKey(turtle) || 
				myTurtleIndices.get(turtle) == myTurtleStates.get(turtle).size() - 1) {
			return new NullDrawingViewState();
		} 
		myTurtleIndices.put(turtle, myTurtleIndices.get(turtle) + 1);
		return myTurtleStates.get(turtle).get(myTurtleIndices.get(turtle));
	}
	
}
