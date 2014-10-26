package turtle.draw;

import javafx.util.Duration;

/**
 * animation for a turtle turning
 * @author Jonathan Tseng
 *
 */
public class TurnTransition extends SLogoTransition {
	
	private boolean myFirst;
	private double myRotate;
	private double myStartRotate;
	
	public TurnTransition() {
		super();
		myFirst = true;
		myRotate = 0;
	}
	
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
