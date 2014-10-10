package turtle.animation;

import transitionstate.TransitionState;
import turtle.Turtle;

public class RotateCounterClockwiseAnimation extends RotateAnimation {

	public RotateCounterClockwiseAnimation() {
		super(false);
	}

	@Override
	public void attachTurtle(Turtle turtle, TransitionState transitionState) {
		attachTurtle(turtle, transitionState, false);
	}

}
