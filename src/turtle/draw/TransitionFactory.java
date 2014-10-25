package turtle.draw;

import java.util.List;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import transitionstate.TransitionState;
import turtle.Turtle;

public class TransitionFactory {
	
	public TransitionFactory() {
		// TODO Auto-generated constructor stub
	}

	public ParallelTransition createAnimation(Turtle turtle, List<TransitionState> states) {
		SequentialTransition sequential = new SequentialTransition();
		for (TransitionState state : states) {
			Transition transition = createTurtleTransition(turtle, state);
			sequential.getChildren().add(transition);
		}
		ParallelTransition animation = new ParallelTransition();
		animation.getChildren().add(sequential);
		return animation;
	}
	
	private Transition createTurtleTransition(Turtle turtle, TransitionState state) {
		turtle.updateVisualState(state);
		SequentialTransition transition = new SequentialTransition();
		TurnTransition turnTransition = createTurnTransition(turtle, state);
		ParallelTransition forwardTransition = createForwardTransition(turtle, state);
		transition.getChildren().addAll(turnTransition, forwardTransition);
		return transition;
	}
	
	private TurnTransition createTurnTransition(Turtle turtle, TransitionState state) {
		TurnTransition turnTransition = new TurnTransition();
		double rotate = state.getRotateClockwise() - state.getRotateCounterClockwise();
		turnTransition.setTurtle(turtle);
		turnTransition.setTurn(rotate);
		return turnTransition;
	}
	
	private ParallelTransition createForwardTransition(Turtle turtle, TransitionState state) {
		ParallelTransition forwardTransition = new ParallelTransition();
		MoveTransition moveTransition = new MoveTransition();
		moveTransition.setTurtle(turtle);
		moveTransition.setDistance(state.getMove());
		forwardTransition.getChildren().add(moveTransition);
		if (turtle.getPen().getPenDown()) {
			PenTransition penTransition = new PenTransition();
			penTransition.setTurtle(turtle);
			penTransition.setDistance(state.getMove());
			forwardTransition.getChildren().add(penTransition);
		}
		return forwardTransition;
	}
	
}
