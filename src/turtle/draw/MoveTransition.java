package turtle.draw;

import javafx.geometry.Point2D;
import turtle.Turtle;

public class MoveTransition extends LinearTransition {

	private boolean myFirst;
	
	public MoveTransition() {
		super();
		myFirst = true;
	}
	
	@Override
	public void setTurtle(Turtle turtle) {
		super.setTurtle(turtle);
		setStartPoint();
	}
	
	private void setStartPoint() {
		super.setStartPoint(myTurtle.getTurtle().getTranslateX(), myTurtle.getTurtle().getTranslateY());
	}

	@Override
	protected void interpolate(double frac) {
		super.interpolate(frac);
		if (myFirst) {
			setStartPoint();
			myFirst = false;
		}
		performWrappingChanges(frac);
		myTurtle.getTurtle().setTranslateX(myStartX + myX * (frac - myDoneFrac));
		myTurtle.getTurtle().setTranslateY(myStartY + myY * (frac - myDoneFrac));
	}

	@Override
	protected void performWrappingChanges(double frac) {
		Point2D start = checkWrapping();
		if (!start.equals(new Point2D(myStartX, myStartY))) {
			setStartPoint(start.getX(), start.getY());
			myX = myX * (1 - frac);
			myY = myY * (1 - frac);
			myDoneFrac = frac;
		}
		
	}

}
