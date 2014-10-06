package interpreter.expression.turtlecommand;

import interpreter.SLogoResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;
import java.util.Collection;
import java.util.List;

public class ForwardCommand extends TurtleCommandExpression {
    private SLogoExpression[] myParameters;
    
    @Override
    public void loadArguments(Collection<SLogoExpression> args) {
        myParameters =  (SLogoExpression[]) args.toArray();
    }

    @Override
    public SLogoResult evaluate() {
        return null;
    }


}
