package turtle;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javafx.animation.ParallelTransition;
import javafx.scene.shape.Line;

/**
 * history state wrapper class for storing turtle history
 * @author Jonathan Tseng
 *
 */
public class TurtleHistoryState {

	private ParallelTransition myAnimation;
	private Set<Line> myLines;
	
	public TurtleHistoryState(ParallelTransition animation, Collection<Line> lines) {
		myAnimation = animation;
		myLines = new HashSet<>(lines);
	}
	
	public Collection<Line> getLines() {
		return myLines;
	}
	
	public ParallelTransition getAnimation() {
		return myAnimation;
	}

}
