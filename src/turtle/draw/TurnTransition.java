package turtle.draw;

import javafx.util.Duration;



public class TurnTransition extends SLogoTransition {
	
	private boolean myFirst;
	private double myRotate;
	private double myStartRotate;
	
	public TurnTransition() {
		super();
		myFirst = true;
	}
//
//	@Override
//	public void setTurtle(Turtle turtle) {
//		super.setTurtle(turtle);
//		myStartRotate = turtle.getTurtle().getRotate();
//	}
	
	public void setTurn(double rotate) {
		myRotate = rotate;
		double time = (rotate == 0) ? 1 : Math.abs(rotate * 10);
		setCycleDuration(new Duration(time));
		//setCycleDuration(new Duration(rotate * 10));
	}
	
	@Override
	protected void interpolate(double frac) {
		if (myFirst) {
			myStartRotate = myTurtle.getTurtle().getRotate();
			myFirst = false;
		}
		myTurtle.getTurtle().setRotate((myStartRotate + myRotate * frac) % 360);
	}

}
