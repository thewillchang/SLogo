package animation;

import model.Turtle;
import transitionstate.TransitionState;

public class RotateClockwiseAnimation extends RotateAnimation {
	
	public RotateClockwiseAnimation() {
		super(true);
	}

	@Override
	public void attachTurtle(Turtle turtle, TransitionState transitionState) {
		attachTurtle(turtle, transitionState, true);
	}
	
}
