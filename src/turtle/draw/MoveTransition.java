// This entire file is part of my masterpiece.
// JONATHAN TSENG

package turtle.draw;

import javafx.geometry.Point2D;
import turtle.Turtle;


/**
 * animation for a turtle moving forward/backward a set amount of distance
 *
 * @author Jonathan Tseng
 *
 */
public class MoveTransition extends LinearTransition {

    public MoveTransition (Turtle turtle) {
        super(turtle);
    }

    @Override
    protected void setStartPoint () {
        super.setStartPoint(myTurtle.getTurtle().getTranslateX(), myTurtle.getTurtle()
                            .getTranslateY());
    }

    @Override
    protected void interpolateChanges (double frac) {
        myTurtle.getTurtle().setTranslateX(myStartX + myX * (frac - myDoneFrac));
        myTurtle.getTurtle().setTranslateY(myStartY + myY * (frac - myDoneFrac));
    }

    @Override
    protected void performWrappingChanges (Point2D newStartPoint, double frac) {
        setStartPoint(newStartPoint.getX(), newStartPoint.getY());
    }

}
