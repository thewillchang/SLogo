package interpreter.expression.query;

import java.util.Deque;
import model.MainModel;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

/**
 * superclass for SLogoExpressions that are Turtle Queries
 * @author Jonathan Tseng
 *
 */
public abstract class TurtleQueryExpression implements SLogoExpression {
    
    protected MainModel myModel;
    @Override
    public void loadArguments(Deque<SLogoExpression> args) {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadModel(MainModel model) {
        myModel = model;
    }

    @Override
    public SLogoResult evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

}
