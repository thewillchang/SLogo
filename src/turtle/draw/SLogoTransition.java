package turtle.draw;

import turtle.Turtle;
import javafx.animation.Interpolator;
import javafx.animation.Transition;

/**
 * abstract superclass for all animations
 * @author Jonathan Tseng
 *
 */
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
