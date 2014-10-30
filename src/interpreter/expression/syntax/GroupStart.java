package interpreter.expression.syntax;

import interpreter.CommandReferenceLibrary;
import interpreter.expression.SLogoExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;
import model.MainModel;


public class GroupStart implements SLogoExpression {
    @Override
    public void loadArguments (Deque<SLogoExpression> args) {
        while (!args.isEmpty()) {

        }
    }

    @Override
    public SLogoResult evaluate () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void loadModel (MainModel model) {
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
    public int getNumArgs () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setValue (String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getValue () {
        // TODO Auto-generated method stub
        return null;
    }
}
