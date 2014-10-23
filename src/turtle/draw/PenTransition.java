package turtle.draw;

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import turtle.Turtle;

public class PenTransition extends LinearTransition {

	private Line myLine;
	private boolean myFirst;
	
	public PenTransition() {
		super();
		myFirst = true;
	}

	@Override
	public void setTurtle(Turtle turtle) {
		super.setTurtle(turtle);
	}
	
	@Override
	public void setDistance(double distance) {
		super.setDistance(distance);
		createLine();
		setEndPoint(myStartX, myStartY);
	}
	
	private void createLine() {
		myLine = new Line();
		setStartPoint();
		formatLine();
		drawLine();
	}
	
	private void formatLine() {
		myLine.setStroke(myTurtle.getPen().getColor());
		myLine.setStrokeWidth(myTurtle.getPen().getWidth());
		myLine.setStrokeLineCap(StrokeLineCap.ROUND);
	}
	
	private void drawLine() {
		if (myDistance != 0) {
			myTurtle.getPen().drawLine(myLine);
		}
	}
	
	private void setStartPoint() {
		double x = myTurtle.getTurtle().getLayoutX() + myTurtle.getTurtle().getTranslateX();
		double y = myTurtle.getTurtle().getLayoutY() + myTurtle.getTurtle().getTranslateY();
		setStartPoint(x, y);
	}
	
	@Override
	protected void setStartPoint(double x, double y) {
		super.setStartPoint(x, y);
		myLine.setStartX(myStartX);
		myLine.setStartY(myStartY);
	}
	
	private void setEndPoint(double x, double y) {
		myLine.setEndX(x);
		myLine.setEndY(y);
	}
	
	@Override
	protected void interpolate(double frac) {
		super.interpolate(frac);
		if (myFirst) {
			setStartPoint();
			myFirst = false;
		}
		performWrappingChanges(frac);
		setEndPoint(myLine.getStartX() + myX * (frac - myDoneFrac), myLine.getStartY() + myY * (frac - myDoneFrac));
	}

	@Override
	protected void performWrappingChanges(double frac) {
		Point2D start = checkWrapping();
		if (!start.equals(new Point2D(myStartX, myStartY))) {
			createLine();
			setStartPoint(start.getX(), start.getY());
			setEndPoint(start.getX(), start.getY());
			myX = myX * (1 - frac);
			myY = myY * (1 - frac);
			myDoneFrac = frac;
		}
	}

}
