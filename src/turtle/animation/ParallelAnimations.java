package turtle.animation;

import java.util.Collection;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;


public class ParallelAnimations {

	private Collection<FullAnimation> myAnimations;
	private Duration myDuration;
	private Timeline myAnimation;
	
	public ParallelAnimations() {
		myAnimation = new Timeline();
		myAnimation.setCycleCount(1);
	}
	
	public void loadAnimations(Collection<FullAnimation> animations) {
		myAnimations = animations;
		Duration max = new Duration(0);
		for (FullAnimation animation : animations) {
			max = (max.compareTo(animation.getDuration()) > 0) ? max : animation.getDuration();
		}
		myDuration = max.multiply(1.1);
		myAnimation.getKeyFrames().add(new KeyFrame(myDuration, event -> doNothing()));
	}
	
	private void doNothing() {
		
	}
	
	public void playParallelAnimations() {
		for (FullAnimation animation : myAnimations) {
			animation.play();
		}
		myAnimation.play();
	}
	
	public void attachOnFinished(EventHandler<ActionEvent> actionEvent) {
		myAnimation.setOnFinished(actionEvent);
	}
	
}
