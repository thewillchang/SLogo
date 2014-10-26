package turtle;

import java.util.ArrayList;

import javafx.animation.ParallelTransition;
import javafx.scene.shape.Line;

/**
 * history state for turtle history representing no history
 * @author Jonathan Tseng
 *
 */
public class NullTurtleHistoryState extends TurtleHistoryState {

	public NullTurtleHistoryState() {
		super(new ParallelTransition(), new ArrayList<Line>());
	}

}
