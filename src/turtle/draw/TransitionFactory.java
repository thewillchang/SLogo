// This entire file is part of my masterpiece.
// JONATHAN TSENG

package turtle.draw;

import java.util.List;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import transitionstate.TransitionState;
import turtle.Turtle;


/**
 * factory for creating animations given a turtle and list of transition states
 *
 * @author Jonathan Tseng
 *
 */
public class TransitionFactory {

    /**
     * creates an animation for a turtle a list of transition states
     * runs each in sequence
     *
     * @param turtle
     * @param states
     * @return
     */
    public ParallelTransition createAnimation (Turtle turtle, List<TransitionState> states) {
        SequentialTransition sequential = new SequentialTransition();
        for (TransitionState state : states) {
            Transition transition = createTurtleTransition(turtle, state);
            sequential.getChildren().add(transition);
        }
        ParallelTransition animation = new ParallelTransition();
        animation.getChildren().add(sequential);
        return animation;
    }

    /**
     * creates an animation for a turtle and a single transition state
     *
     * @param turtle
     * @param state
     * @return
     */
    private Transition createTurtleTransition (Turtle turtle, TransitionState state) {
        turtle.updateVisualState(state);
        SequentialTransition transition = new SequentialTransition();
        TurnTransition turnTransition = createTurnTransition(turtle, state);
        ParallelTransition forwardTransition = createForwardTransition(turtle, state);
        transition.getChildren().addAll(turnTransition, forwardTransition);
        return transition;
    }

    /**
     * creates an animation for a turtle to turn for a given transition state
     *
     * @param turtle
     * @param state
     * @return
     */
    private TurnTransition createTurnTransition (Turtle turtle, TransitionState state) {
        TurnTransition turnTransition = new TurnTransition(turtle);
        double rotate = state.getRotateClockwise() - state.getRotateCounterClockwise();
        turnTransition.setTurn(rotate);
        return turnTransition;
    }

    /**
     * creates an animation for a turtle to move forward
     * takes into account whether or not to draw a line as well
     *
     * @param turtle
     * @param state
     * @return
     */
    private ParallelTransition createForwardTransition (Turtle turtle, TransitionState state) {
        ParallelTransition forwardTransition = new ParallelTransition();
        MoveTransition moveTransition = new MoveTransition(turtle);
        moveTransition.setDistance(state.getMove());
        forwardTransition.getChildren().add(moveTransition);
        if (turtle.getPen().getPenDown()) {
            PenTransition penTransition = new PenTransition(turtle);
            penTransition.setDistance(state.getMove());
            forwardTransition.getChildren().add(penTransition);
        }
        return forwardTransition;
    }

}
