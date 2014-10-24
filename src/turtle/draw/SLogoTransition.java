package turtle.draw;

import turtle.Turtle;
import javafx.animation.Interpolator;
import javafx.animation.Transition;

public abstract class SLogoTransition extends Transition {

	protected Turtle myTurtle;
	
	protected SLogoTransition() {
		setCycleCount(1);
		setInterpolator(Interpolator.LINEAR);
	}
	
	public void setTurtle(Turtle turtle) {
		myTurtle = turtle;
	}

}
