package turtle.animation;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import transitionstate.TransitionState;
import turtle.Turtle;

public class FullAnimation {

	SLogoAnimation myAnimationHead;
	SLogoAnimation myAnimationTail;
	List<SLogoAnimation> myAnimations;
	Duration myDuration;
	
	public FullAnimation() {
		myDuration = new Duration(0);
		myAnimations = new ArrayList<>();
	} 
	
	/**
	 * loads a list of transition states to animate in one "turn"
	 * @param turtle
	 * @param states
	 */
	public void loadAnimation(Turtle turtle, List<TransitionState> states) {
		for (TransitionState state : states) {
			myAnimations.add(rotateClockTurtle(turtle, state));
			myAnimations.add(rotateCounterClockTurtle(turtle, state));
			myAnimations.add(walkTurtle(turtle, state));
		}
		myAnimationHead = myAnimations.get(0);
		myAnimationTail = myAnimations.get(myAnimations.size() - 1);
		linkAnimations();
		calculateDuration();
	}
	
	/**
	 * returns the duration of the full animation
	 * @return
	 */
	public Duration getDuration() {
		return myDuration;
	}
	
	/**
	 * plays the animation
	 */
	public void play() {
		myAnimationHead.startAnimation();
	}
	
	/**
	 * attaches an event to happen upon finishing the animation
	 * @param actionEvent
	 */
	public void attachOnFinish(EventHandler<ActionEvent> actionEvent) {
		myAnimationTail.attachOnFinish(actionEvent);
	}
	
	/**
	 * links the animations together
	 */
	private void linkAnimations() {
		SLogoAnimation currentAnimation = myAnimationHead;
		for (SLogoAnimation animation : myAnimations.subList(1, myAnimations.size())) {
			currentAnimation.linkNextAnimation(animation);
			currentAnimation = animation;
		}
	}
	
	/**
	 * calculates the duration of this full animation
	 */
	private void calculateDuration() {
		for (SLogoAnimation animation : myAnimations) {
			myDuration = myDuration.add(animation.getDuration());
		}
	}
	
	/**
	 * creates an animation to walk the turtle
	 * @param turtle
	 * @param transitionState
	 * @return
	 */
	private SLogoAnimation walkTurtle(Turtle turtle, TransitionState transitionState) {
		TransitionAnimation transition = new TransitionAnimation();
		transition.attachTurtle(turtle, transitionState);
		return transition;
	}
	
	/**
	 * creates an animation to rotate the turtle clockwise
	 * @param turtle
	 * @param transitionState
	 * @return
	 */	
	private SLogoAnimation rotateClockTurtle(Turtle turtle, TransitionState transitionState) {
		RotateClockwiseAnimation rotation = new RotateClockwiseAnimation();
		rotation.attachTurtle(turtle, transitionState);
		return rotation;
	}

	/**
	 * creates an animation to rotate the turtle counterclockwise
	 * @param turtle
	 * @param transitionState
	 * @return
	 */
	private SLogoAnimation rotateCounterClockTurtle(Turtle turtle, TransitionState transitionState) {
		RotateCounterClockwiseAnimation rotation = new RotateCounterClockwiseAnimation();
		rotation.attachTurtle(turtle, transitionState);
		return rotation;
	}

}
