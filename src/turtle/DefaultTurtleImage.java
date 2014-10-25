package turtle;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class DefaultTurtleImage extends TurtleImage {

	private final static int FRAMES_PER_SECOND = 7;
	
	private Timeline myAnimation;
	private boolean myAnimationFlip;
	
	private Circle myBody;
	private Ellipse myHead;
	private Ellipse myFrontLeftFoot;
	private Ellipse myFrontRightFoot;
	private Ellipse myBackLeftFoot;
	private Ellipse myBackRightFoot;
	private Ellipse myTail;
	private List<Shape> myTurtleBodyParts;

	public DefaultTurtleImage() {
		super();
		myAnimation = new Timeline();
		createTurtle();
		animate();
	}
	
	private void createTurtle() {
		myTurtleBodyParts = new ArrayList<Shape>();
		createLegs();
		createHeadBodyTail();
		myTurtleBodyParts.add(myBody);
		myTurtleBodyParts.add(myHead);
		myTurtleBodyParts.add(myFrontLeftFoot);
		myTurtleBodyParts.add(myFrontRightFoot);
		myTurtleBodyParts.add(myBackLeftFoot);
		myTurtleBodyParts.add(myBackRightFoot);
		myTurtleBodyParts.add(myTail);
		this.getChildren().clear();
		this.getChildren().addAll(myHead, myFrontLeftFoot,
				myFrontRightFoot, myBackLeftFoot, myBackRightFoot, myTail,
				myBody);
		colorTurtle(Color.LIMEGREEN);
	}

	/**
	 * creates head, body, and tail of turtle
	 */
	private void createHeadBodyTail() {
		myHead = new Ellipse(ourSize.width / 5, ourSize.height / 4);
		myHead.setTranslateY(myHead.getTranslateY() - 2 * myHead.getRadiusY());

		myTail = new Ellipse(ourSize.width / 12, ourSize.height / 4);
		myTail.setTranslateY(myTail.getTranslateY() + 2 * myTail.getRadiusY());

		myBody = new Circle(ourSize.height / 2);
		myBody.setStroke(Color.BROWN);
		myBody.setStrokeWidth(getRadius() / 20);
	}

	/**
	 * creates legs of turtle
	 */
	private void createLegs() {
		myFrontLeftFoot = new Ellipse(ourSize.width / 6, ourSize.height / 4);
		myFrontLeftFoot.setTranslateX(myFrontLeftFoot.getTranslateX() - 2
				* myFrontLeftFoot.getRadiusX());
		myFrontLeftFoot.setTranslateY(myFrontLeftFoot.getTranslateY()
				- myFrontLeftFoot.getRadiusY());
		myFrontLeftFoot.setRotate(-45);

		myFrontRightFoot = new Ellipse(ourSize.width / 6, ourSize.height / 4);
		myFrontRightFoot.setTranslateX(myFrontRightFoot.getTranslateX() + 2
				* myFrontRightFoot.getRadiusX());
		myFrontRightFoot.setTranslateY(myFrontRightFoot.getTranslateY()
				- myFrontRightFoot.getRadiusY());
		myFrontRightFoot.setRotate(45);

		myBackLeftFoot = new Ellipse(ourSize.width / 6, ourSize.height / 4);
		myBackLeftFoot.setTranslateX(myBackLeftFoot.getTranslateX() - 2
				* myBackLeftFoot.getRadiusX());
		myBackLeftFoot.setTranslateY(myBackLeftFoot.getTranslateY()
				+ myBackLeftFoot.getRadiusY());
		myBackLeftFoot.setRotate(45);

		myBackRightFoot = new Ellipse(ourSize.width / 6, ourSize.height / 4);
		myBackRightFoot.setTranslateX(myBackRightFoot.getTranslateX() + 2
				* myBackRightFoot.getRadiusX());
		myBackRightFoot.setTranslateY(myBackRightFoot.getTranslateY()
				+ myBackRightFoot.getRadiusY());
		myBackRightFoot.setRotate(-45);
	}

	/**
	 * animates the turtle indefinitely (wiggling of legs)
	 */
	private void animate() {
		myAnimation = new Timeline();
		myAnimation.setCycleCount(Timeline.INDEFINITE);
		myAnimation.getKeyFrames().add(
				new KeyFrame(Duration.millis(1000 / FRAMES_PER_SECOND),
						event -> animateTurtle()));
		myAnimation.play();
	}

	/**
	 * animates the turtle
	 */
	private void animateTurtle() {
		int change = (myAnimationFlip) ? 30 : -30;
		myFrontLeftFoot.setRotate(myFrontLeftFoot.getRotate() + change);
		myFrontRightFoot.setRotate(myFrontRightFoot.getRotate() - change);
		myBackLeftFoot.setRotate(myBackLeftFoot.getRotate() + change);
		myBackRightFoot.setRotate(myBackRightFoot.getRotate() - change);
		myAnimationFlip = !myAnimationFlip;
	}

	private void colorTurtle(Color color) {
		for (Node child : this.getChildren()) {
			Shape bodyPart = (Shape) child;
			bodyPart.setFill(color);
		}
	}

	@Override
	protected void selectedChanged() {
		if (myIsSelected) {
			for (Shape bodyPart : myTurtleBodyParts) {
				bodyPart.setStroke(ourSelectedColor);
				bodyPart.setStrokeWidth(getRadius() / 10);
			}
		} else {
			for (Shape bodyPart : myTurtleBodyParts) {
				if (!bodyPart.equals(myBody)) {
					bodyPart.setStrokeWidth(0);
				} else {
					bodyPart.setStrokeWidth(getRadius() / 20);
					bodyPart.setStroke(Color.BROWN);
				}
			}
		}
	}

	@Override
	public double getRadius() {
		return ourSize.getHeight() / 2 + myHead.getRadiusY() * 1.2;
	}

}
