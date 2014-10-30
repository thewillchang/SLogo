// This entire file is part of my masterpiece.
// JONATHAN TSENG

package turtle.draw;

import javafx.util.Duration;
import turtle.Turtle;


/**
 * animation for a turtle turning
 *
 * @author Jonathan Tseng
 *
 */
public class TurnTransition extends SLogoTransition {

    private boolean myFirst;
    private double myRotate;
    private double myStartRotate;

    public TurnTransition (Turtle turtle) {
        super(turtle);
        myFirst = true;
        myRotate = 0;
    }

    /**
     * sets the number of degrees this animation will turn the turtle
     *
     * @param rotate
     */
    public void setTurn (double rotate) {
        myRotate = rotate;
        double time = (rotate == 0) ? 1 : Math.abs(rotate * MILLIS_PER_FRAME);
        setCycleDuration(new Duration(time));
    }

    @Override
    protected void interpolate (double frac) {
        if (myFirst) {
            myStartRotate = myTurtle.getTurtle().getRotate();
            myFirst = false;
        }
        myTurtle.getTurtle().setRotate((myStartRotate + myRotate * frac) % DEGREES_PER_CIRCLE);
    }

}
