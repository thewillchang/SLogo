package turtle.draw;

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import turtle.Turtle;

public class PenTransition extends LinearTransition {

	private Line myLine;

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
	
	@Override
	protected void setStartPoint() {
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
	protected void interpolateChanges(double frac) {
		setEndPoint(myLine.getStartX() + myX * (frac - myDoneFrac), myLine.getStartY() + myY * (frac - myDoneFrac));
	}

	@Override
	protected void performWrappingChanges(Point2D newStartPoint, double frac) {
		createLine();
		setStartPoint(newStartPoint.getX(), newStartPoint.getY());
		setEndPoint(newStartPoint.getX(), newStartPoint.getY());
		myX = myX * (1 - frac);
		myY = myY * (1 - frac);
		myDoneFrac = frac;
	}

}
