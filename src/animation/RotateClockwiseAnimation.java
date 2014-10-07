package animation;

import transitionstate.TransitionState;
import viewcontroller.TurtleViewController;

public class RotateClockwiseAnimation extends RotateAnimation {
	
	public RotateClockwiseAnimation() {
		super(true);
	}

	@Override
	public void attachTurtle(TurtleViewController turtleViewController,
			TransitionState transitionState) {
		attachTurtle(turtleViewController, transitionState, true);
	}
	
}
