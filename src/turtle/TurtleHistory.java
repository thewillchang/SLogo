package turtle;

import java.util.ArrayList;
import java.util.List;

/**
 * history model for an individual turtle used for undo/redo
 * @author Jonathan Tseng
 *
 */
public class TurtleHistory {

	private List<TurtleHistoryState> myStates;
	private int myIndex;
	
	public TurtleHistory() {
		myStates = new ArrayList<>();
		myIndex = -1;
	}
	
	public void addHistory(TurtleHistoryState state) {
		List<TurtleHistoryState> states = new ArrayList<>();
		for (int i = 0; i <= myIndex; i++) {
			states.add(myStates.get(i));
		}
		myStates = states;
		myStates.add(state);
		myIndex++;
	}
	
	public TurtleHistoryState undo() {
		if (myIndex == -1) {
			return new NullTurtleHistoryState();
		}
		TurtleHistoryState state = myStates.get(myIndex);
		state.getAnimation().setRate(Math.abs(state.getAnimation().getRate() * -1));
		myIndex--;
		return state;
	}
	
	public TurtleHistoryState redo() {
		if (myIndex == myStates.size() - 1) {
			return new NullTurtleHistoryState();
		}
		myIndex++;
		return myStates.get(myIndex);
	}
	
}
