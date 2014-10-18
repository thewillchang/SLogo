package interpreter.expression.variable;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.singleturtle.TurtleCommandExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import transitionstate.TransitionState;

public class MakeUserInstruction extends TurtleCommandExpression{
    private Deque<SLogoExpression> myParameters;

    public MakeUserInstruction () {
        myParameters = new ArrayDeque<>();
    }
    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
    }

    @Override
    public SLogoResult evaluate() {
        return null;
    }

}
