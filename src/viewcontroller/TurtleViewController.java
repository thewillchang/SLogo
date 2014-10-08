package viewcontroller;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import application.Main;

/**
 * view controller for an individual turtle object
 * @author Jonathan Tseng
 *
 */
public class TurtleViewController implements Observer, ViewController {

	private final static int FRAMES_PER_SECOND = 10;
	
	private ImageView myTurtleImageView;
	private Group myTurtle;
	private Dimension mySize = new Dimension(Main.SIZE.width / 40, Main.SIZE.width / 40);
	
	private Timeline myAnimation;
	private int myAnimationCount;
	
	private Circle myBody;
	private Ellipse myHead;
	private Ellipse myFrontLeftFoot;
	private Ellipse myFrontRightFoot;
	private Ellipse myBackLeftFoot;
	private Ellipse myBackRightFoot;
	
	private List<Shape> turtleBodyParts;
	
	public TurtleViewController() {
		myTurtle = new Group();
		myAnimation = new Timeline();
		createTurtle();
		setAnimation();
	}
	
	private void createTurtle() {
		turtleBodyParts = new ArrayList<Shape>();
		myBody = new Circle(mySize.height / 2);
		myBody.setStroke(Color.BROWN);
		
		myHead = new Ellipse(mySize.width / 5, mySize.height / 4);
		myHead.setTranslateY(myHead.getTranslateY() - 2 * myHead.getRadiusY());
		
		myFrontLeftFoot = new Ellipse(mySize.width / 6, mySize.height / 4);
		myFrontLeftFoot.setTranslateX(myFrontLeftFoot.getTranslateX() - 2 * myFrontLeftFoot.getRadiusX());
		myFrontLeftFoot.setTranslateY(myFrontLeftFoot.getTranslateY() - myFrontLeftFoot.getRadiusY());
		myFrontLeftFoot.setRotate(-45);
		
		myFrontRightFoot = new Ellipse(mySize.width / 6, mySize.height / 4);
		myFrontRightFoot.setTranslateX(myFrontRightFoot.getTranslateX() + 2 * myFrontRightFoot.getRadiusX());
		myFrontRightFoot.setTranslateY(myFrontRightFoot.getTranslateY() - myFrontRightFoot.getRadiusY());
		myFrontRightFoot.setRotate(45);
		
		myBackLeftFoot = new Ellipse(mySize.width / 6, mySize.height / 4);
		myBackLeftFoot.setTranslateX(myBackLeftFoot.getTranslateX() - 2 * myBackLeftFoot.getRadiusX());
		myBackLeftFoot.setTranslateY(myBackLeftFoot.getTranslateY() + myBackLeftFoot.getRadiusY());
		myBackLeftFoot.setRotate(45);
		
		myBackRightFoot = new Ellipse(mySize.width / 6, mySize.height / 4);
		myBackRightFoot.setTranslateX(myBackRightFoot.getTranslateX() + 2 * myBackRightFoot.getRadiusX());
		myBackRightFoot.setTranslateY(myBackRightFoot.getTranslateY() + myBackRightFoot.getRadiusY());
		myBackRightFoot.setRotate(-45);
		
		Ellipse tail = new Ellipse(mySize.width / 12, mySize.height / 4);
		tail.setTranslateY(tail.getTranslateY() + 2 * tail.getRadiusY());
		
		turtleBodyParts.add(myBody);
		turtleBodyParts.add(myHead);
		turtleBodyParts.add(myFrontLeftFoot);
		turtleBodyParts.add(myFrontRightFoot);
		turtleBodyParts.add(myBackLeftFoot);
		turtleBodyParts.add(myBackRightFoot);
		turtleBodyParts.add(tail);
		myTurtle.getChildren().clear();
		myTurtle.getChildren().addAll(myHead, myFrontLeftFoot, myFrontRightFoot, myBackLeftFoot, myBackRightFoot, tail, myBody);
		colorTurtle(Color.LIMEGREEN);
	}	
	
	private void setAnimation() {
		myAnimation = new Timeline();
		myAnimation.setCycleCount(Timeline.INDEFINITE);
		myAnimation.getKeyFrames().add(new KeyFrame(
				Duration.millis(1000 / FRAMES_PER_SECOND), 
				event -> animateTurtle()));
		myAnimation.play();
	}
	
	/**
	 * animates the turtle
	 */
	private void animateTurtle() {	
		myAnimationCount++;
		int change = (myAnimationCount % 2 == 0) ? 30 : -30;
		myFrontLeftFoot.setRotate(myFrontLeftFoot.getRotate() + change);
		myFrontRightFoot.setRotate(myFrontRightFoot.getRotate() - change);
		myBackLeftFoot.setRotate(myBackLeftFoot.getRotate() + change);
		myBackRightFoot.setRotate(myBackRightFoot.getRotate() - change);
	}
	
	/**
	 * colors the entire turtle
	 * @param color
	 */
	public void colorTurtle(Color color) {
		for (Node child : myTurtle.getChildren()) {
			Shape bodyPart = (Shape) child;
			bodyPart.setFill(color);
		}
	}
	
	public double getRadius() {
		return mySize.getHeight() / 2;
	}
	
	public void setImage(Image image) {
		myTurtleImageView = new ImageView(image);
		myAnimation.stop();
	}
	
	@Override
	public Node getNode() {
		return (myTurtleImageView == null) ? myTurtle : myTurtleImageView;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
