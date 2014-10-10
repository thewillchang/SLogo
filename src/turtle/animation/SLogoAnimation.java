package turtle.animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import transitionstate.TransitionState;
import turtle.Turtle;

public abstract class SLogoAnimation {

	private static final int FRAMES_PER_SECOND = 100;
	private EventHandler<ActionEvent> myOneFrame;
    private Timeline myAnimation;

    public SLogoAnimation() {
        myAnimation = new Timeline();
        myAnimation.setRate(10);
    }
    
    public Duration getDuration() {
    	return new Duration(myAnimation.getTotalDuration().toMillis() / myAnimation.getRate());
    }
    
    /**
     * attaches a TurtleViewController and TransitionState to the animation
     * @param turtleViewController
     * @param transitionState
     */
    public abstract void attachTurtle(Turtle turtle, TransitionState transitionState);
    
    /**
     * attaches the frame representing what to be executed every cycle of the animation
     * @param oneFrame
     */
    protected void attachFrame(EventHandler<ActionEvent> oneFrame) {
    	myOneFrame = oneFrame;
    	KeyFrame frame = start();
    	myAnimation.getKeyFrames().add(frame);
    }
    
    /**
     * sets the length (in number of cycles) for the animation
     * @param numberCycles
     */
    protected void setAnimationLength(double numberCycles) {
    	myAnimation.setCycleCount((int) numberCycles + 1);
    }
    
    /**
     * starts the animation
     */
    public void startAnimation () {
        myAnimation.play();
    }
    
    /**
     * Create the game's frame
     */
    private KeyFrame start () {
        return new KeyFrame(Duration.millis(1000 / FRAMES_PER_SECOND), myOneFrame);
    }
    
    /**
     * links another SLogoAnimation to be animated after this animation completes
     * @param animation
     */
    public void linkNextAnimation(SLogoAnimation animation) {
    	myAnimation.setOnFinished(event -> animation.startAnimation());
    }
    
    /**
     * attaches an event to be executed when the animation finishes
     * @param event
     */
    public void attachOnFinish(EventHandler<ActionEvent> event) {
    	myAnimation.setOnFinished(event);
    }
    
}
