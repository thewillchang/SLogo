package interpreter.expression.syntax;

import interpreter.CommandReferenceLibrary;
import interpreter.SLogoResult;
import interpreter.SyntaxResult;
import interpreter.TurtleCommandResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SyntaxExpression;
import interpreter.expression.singleturtle.TurtleCommandExpression;
import java.util.ArrayDeque;
import java.util.Deque;
import model.MainModel;
import transitionstate.TransitionState;

public class ListEnd extends SyntaxExpression {
    private int myNumArgs;
    @Override
    public void loadArguments (Deque<SLogoExpression> args) {
    }

    @Override
    public SLogoResult evaluate () {
        return new SyntaxResult();
    }

    @Override
    public void setNumArgs (int value) {
        myNumArgs = value;
        
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
    public void setValue (String value) {
        // TODO Auto-generated method stub
        
    }
}