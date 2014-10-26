package transitionstate;

/**
 * transition state that represents doing no transition between evaluations
 * @author Jonathan Tseng
 *
 */
public class NullTransitionState extends TransitionState {
    public NullTransitionState() {
        super(PenChange.NO_CHANGE, VisibleChange.NO_CHANGE, 0, 0, 0);
    }
}
