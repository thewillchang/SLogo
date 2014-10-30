// This entire file is part of my masterpiece.
// JONATHAN TSENG

package turtle.draw;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import turtle.Turtle;


/**
 * abstract superclass for all animations
 *
 * @author Jonathan Tseng
 *
 */
public abstract class SLogoTransition extends Transition {

    protected static final int DEGREES_PER_CIRCLE = 360;
    protected static final int MILLIS_PER_FRAME = 10;
    protected Turtle myTurtle;

    protected SLogoTransition (Turtle turtle) {
        setCycleCount(1);
        setInterpolator(Interpolator.LINEAR);
        myTurtle = turtle;
    }

}
