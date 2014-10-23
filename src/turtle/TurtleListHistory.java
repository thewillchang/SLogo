package turtle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.animation.ParallelTransition;
import javafx.scene.shape.Line;

public class TurtleListHistory {
	
	private List<Set<Turtle>> myMovedTurtlesHistory;
	private int myIndex;
	
	public TurtleListHistory() {
		myMovedTurtlesHistory = new ArrayList<>();
		myIndex = -1;
	}
	
	public void updateList(Collection<Turtle> movedTurtles) {
		List<Set<Turtle>> history = new ArrayList<>();
		for (int i = 0; i <= myIndex; i++) {
			history.add(myMovedTurtlesHistory.get(i));
		}
		myMovedTurtlesHistory = history;
		myMovedTurtlesHistory.add(new HashSet<>(movedTurtles));
		myIndex++;
	}
	
	public TurtleHistoryState undo() {
		if (myIndex == -1) {
			return new NullTurtleHistoryState();
		}
		ParallelTransition animation = new ParallelTransition();
		List<Line> lines = new ArrayList<>();
		for (Turtle turtle : myMovedTurtlesHistory.get(myIndex)) {
			TurtleHistoryState state = turtle.undo();
			if (!(state instanceof NullTurtleHistoryState)) {
				animation.getChildren().add(state.getAnimation());
				lines.addAll(state.getLines());
			}
		}
		TurtleHistoryState undoState = new TurtleHistoryState(animation, lines);
		myIndex--;
		return undoState;
	}
	
	public TurtleHistoryState redo() {
		if (myIndex == myMovedTurtlesHistory.size() - 1) {
			return new NullTurtleHistoryState();
		}
		myIndex++;
		ParallelTransition animation = new ParallelTransition();
		List<Line> lines = new ArrayList<>();
		for (Turtle turtle : myMovedTurtlesHistory.get(myIndex)) {
			TurtleHistoryState state = turtle.redo();
			if (!(state instanceof NullTurtleHistoryState)) {
				animation.getChildren().add(state.getAnimation());
				lines.addAll(state.getLines());
			}
		}
		TurtleHistoryState undoState = new TurtleHistoryState(animation, lines);
		return undoState;
	}

}
