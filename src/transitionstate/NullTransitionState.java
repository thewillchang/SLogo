package transitionstate;

public class NullTransitionState extends TransitionState {
    public NullTransitionState() {
        super(PenChange.NO_CHANGE, VisibleChange.NO_CHANGE, 0, 0, 0);
    }
}
