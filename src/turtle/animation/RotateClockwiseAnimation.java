package turtle.animation;

import transitionstate.TransitionState;
import turtle.Turtle;

public class RotateClockwiseAnimation extends RotateAnimation {
	
	public RotateClockwiseAnimation() {
		super(true);
	}

	@Override
	public void attachTurtle(Turtle turtle, TransitionState transitionState) {
		attachTurtle(turtle, transitionState, true);
	}
	
}
