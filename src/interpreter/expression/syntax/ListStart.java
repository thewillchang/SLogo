package interpreter.expression.syntax;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.singleturtle.TurtleCommandExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import transitionstate.TransitionState;

public class ListStart implements SLogoExpression {

    @Override
    public void loadArguments (Deque<SLogoExpression> args) {
    }

    @Override
    public SLogoResult evaluate () {
        return null;
    }
}