package turtle.draw;

import javafx.geometry.Point2D;
import turtle.Turtle;

public class MoveTransition extends LinearTransition {
	
	@Override
	public void setTurtle(Turtle turtle) {
		super.setTurtle(turtle);
		setStartPoint();
	}
	
	@Override
	protected void setStartPoint() {
		super.setStartPoint(myTurtle.getTurtle().getTranslateX(), myTurtle.getTurtle().getTranslateY());
	}

	@Override
	protected void interpolateChanges(double frac) {
		myTurtle.getTurtle().setTranslateX(myStartX + myX * (frac - myDoneFrac));
		myTurtle.getTurtle().setTranslateY(myStartY + myY * (frac - myDoneFrac));
	}

	@Override
	protected void performWrappingChanges(Point2D newStartPoint, double frac) {
		setStartPoint(newStartPoint.getX(), newStartPoint.getY());
		myX = myX * (1 - frac);
		myY = myY * (1 - frac);
		myDoneFrac = frac;
	}

}
