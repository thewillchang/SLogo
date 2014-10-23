package turtle;

import java.util.ArrayList;

import javafx.animation.ParallelTransition;
import javafx.scene.shape.Line;

public class NullTurtleHistoryState extends TurtleHistoryState {

	public NullTurtleHistoryState() {
		super(new ParallelTransition(), new ArrayList<Line>());
	}

}
