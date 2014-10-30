// This entire file is part of my masterpiece.
// JONATHAN TSENG

package turtle.drawtest;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.Transition;
import org.junit.Test;
import transitionstate.TransitionState;
import transitionstate.TransitionState.PenChange;
import transitionstate.TransitionState.VisibleChange;
import turtle.Turtle;
import turtle.draw.TransitionFactory;


public class TransitionFactoryTest {

    /**
     * tests the forward transition to run the correct amount of time
     */
    @Test
    public void forwardTransitionTest () {
        double distance = 100;
        Turtle turtle = new Turtle();
        List<TransitionState> states = new ArrayList<>();
        TransitionState state = new TransitionState(PenChange.CHANGE_DOWN,
                                                    VisibleChange.CHANGE_VISIBLE,
                                                    distance,
                                                    0,
                                                    0);
        states.add(state);
        Transition animation = new TransitionFactory().createAnimation(turtle, states);
        assertEquals(animation.getCycleDuration().toMillis(), distance * 10, 5);
    }

    /**
     * tests the turn transition to run the correct amount of time
     */
    @Test
    public void rotateTransitionTest () {
        double rotation = 100;
        Turtle turtle = new Turtle();
        List<TransitionState> states = new ArrayList<>();
        TransitionState state = new TransitionState(PenChange.CHANGE_DOWN,
                                                    VisibleChange.CHANGE_VISIBLE,
                                                    0,
                                                    rotation,
                                                    0);
        states.add(state);
        Transition animation = new TransitionFactory().createAnimation(turtle, states);
        assertEquals(animation.getCycleDuration().toMillis(), rotation * 10, 5);
    }

}
