package animation;

import transitionstate.TransitionState;
import viewcontroller.TurtleViewController;

public class RotateCounterClockwiseAnimation extends RotateAnimation {

	public RotateCounterClockwiseAnimation() {
		super(false);
	}

	@Override
	public void attachTurtle(TurtleViewController turtleViewController,
			TransitionState transitionState) {
		attachTurtle(turtleViewController, transitionState, false);
	}

}
