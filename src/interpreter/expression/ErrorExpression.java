package interpreter.expression;

import interpreter.CommandReferenceLibrary;
import interpreter.result.ErrorResult;
import interpreter.result.SLogoResult;
import java.util.Deque;
import model.MainModel;
import exceptions.SLogoParsingException;

public class ErrorExpression implements SLogoExpression {
    private Exception myException;
    
    public ErrorExpression (Exception e) {
        myException = e;
    }
    
    @Override
    public void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException,
                                                           NullPointerException {
    }

    @Override
    public void setNumArgs (int value) {
    }

    @Override
    public void loadLibrary (CommandReferenceLibrary library) {
    }

    @Override
    public void loadModel (MainModel model) {
    }

    @Override
    public int getNumArgs () {
        return 0;
    }

    @Override
    public SLogoResult evaluate () {
        return new ErrorResult (myException);
    }

    @Override
    public void setValue (String value) {
    }

    @Override
    public String getValue () {
        return "";
    }

}
