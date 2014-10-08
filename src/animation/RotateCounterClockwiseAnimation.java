package animation;

import model.Turtle;
import transitionstate.TransitionState;

public class RotateCounterClockwiseAnimation extends RotateAnimation {

	public RotateCounterClockwiseAnimation() {
		super(false);
	}

	@Override
	public void attachTurtle(Turtle turtle, TransitionState transitionState) {
		attachTurtle(turtle, transitionState, false);
	}

}
