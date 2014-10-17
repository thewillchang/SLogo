package interpreter.expression.variable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import transitionstate.TransitionState;
import exceptions.SLogoParsingException;
import interpreter.ControlStructureResult;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.syntax.ListEnd;
import interpreter.expression.syntax.ListStart;

public class If implements SLogoExpression {
    private SLogoExpression myMaxRep;
    private List<SLogoExpression>  myList = new ArrayList<>();
    //if expr is not 0, runs the commands given in the list
    //returns the value of the final command executed
    
    @Override
    public void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException,
                                                           NullPointerException {

        
    }

    @Override
    public SLogoResult evaluate () {
        // TODO Auto-generated method stub
        return null;
    }

}
