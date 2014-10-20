package interpreter.expression;

import java.util.Deque;
import model.MainModel;
import exceptions.SLogoParsingException;
import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;

/**
 * class of SLogoExpressions for User Defined Expressions
 * @author Jonathan Tseng
 *
 */
public class UserDefinedExpression implements SLogoExpression{

    @Override
    public void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException,
                                                           NullPointerException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNumArgs (int value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadLibrary (CommandReferenceLibrary library) {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadModel (MainModel model) {
        // TODO Auto-generated method stub

    }

    @Override
    public SLogoResult evaluate () {
        // TODO Auto-generated method stub
        return null;
    }

}
