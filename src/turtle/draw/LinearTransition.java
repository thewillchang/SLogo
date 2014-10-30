// This entire file is part of my masterpiece.
// JONATHAN TSENG

package turtle.draw;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Duration;
import turtle.Turtle;
import viewcontroller.turtlegrid.GridViewController;


/**
 * abstract superclass for linear animations
 * checks/handles wrapping
 *
 * @author Jonathan Tseng
 *
 */
public abstract class LinearTransition extends SLogoTransition {

    private boolean myFirst;
    protected double myStartX;
    protected double myStartY;
    protected double myX;
    protected double myY;
    protected double myDistance;
    protected double myDoneFrac;
    private boolean myWrappingOccurred;

    protected LinearTransition (Turtle turtle) {
        super(turtle);
        myDoneFrac = 0;
        myDistance = 0;
        myFirst = true;
    }

    /**
     * sets the distance for the turtle to move for this animation
     *
     * @param distance
     */
    public void setDistance (double distance) {
        myDistance = distance;
        double time = (distance == 0) ? 1 : Math.abs(distance * MILLIS_PER_FRAME);
        setCycleDuration(new Duration(time));
    }

    @Override
    protected void interpolate (double frac) {
        if (myFirst) {
            setStartPoint();
            myFirst = false;
        }
        setChanges();
        Point2D newStartPoint = checkWrapping();
        if (myWrappingOccurred) {
            myX = myX * (1 - frac);
            myY = myY * (1 - frac);
            myDoneFrac = frac;
            performWrappingChanges(newStartPoint, frac);
        }
        interpolateChanges(frac);
        myWrappingOccurred = false;
    }

    /**
     * what to do when interpolate is called (a single frame of the transition
     *
     * @param frac
     */
    protected abstract void interpolateChanges (double frac);

    /**
     * what to do when wrapping occurs, given the new wrapped to point and interpolation
     *
     * @param newStartPoint
     * @param frac
     */
    protected abstract void performWrappingChanges (Point2D newStartPoint, double frac);

    /**
     * sets the start point to the given x and y
     *
     * @param x
     * @param y
     */
    protected void setStartPoint (double x, double y) {
        myStartX = x;
        myStartY = y;
    }

    /**
     * sets the start point of the transition's movement
     */
    protected abstract void setStartPoint ();

    /**
     * checks if wrapping occurs during the animation and returns a
     * Point2D corresponding to where the turtle wraps to
     *
     * @return
     */
    protected Point2D checkWrapping () {
        Node turtleNode = myTurtle.getTurtle();
        double x = turtleNode.getTranslateX();
        double y = turtleNode.getTranslateY();
        if (turtleNode.getTranslateX() > GridViewController.SIZE.width -
                                         myTurtle.getTurtleRadius()) {
            x = myTurtle.getTurtleRadius();
        }
        else if (turtleNode.getTranslateX() < myTurtle.getTurtleRadius()) {
            x = GridViewController.SIZE.width - myTurtle.getTurtleRadius();
        }
        else if (turtleNode.getTranslateY() > GridViewController.SIZE.height -
                                              myTurtle.getTurtleRadius()) {
            y = myTurtle.getTurtleRadius();
        }
        else if (turtleNode.getTranslateY() < myTurtle.getTurtleRadius()) {
            y = GridViewController.SIZE.height - myTurtle.getTurtleRadius();
        }
        else {
            return new Point2D(myStartX, myStartY);
        }
        myWrappingOccurred = true;
        return new Point2D(x, y);
    }

    /**
     * calculates the movement in x and the movement in y to be moved based on the rotation of the
     * turtle
     */
    private void setChanges () {
        double rotation = scaleRotation(myTurtle.getTurtle().getRotate());
        myX = myDistance * Math.sin(Math.toRadians(rotation));
        myY = myDistance * -1 * Math.cos(Math.toRadians(rotation));
    }

    /**
     * scales the rotation of the turtle to be between 0 and 360
     *
     * @param rotate
     * @return
     */
    private double scaleRotation (double rotate) {
        double rotation = rotate % DEGREES_PER_CIRCLE;
        if (rotation < 0) {
            rotation = DEGREES_PER_CIRCLE + rotation;
        }
        return rotation;
    }

}
