package interpreter.expression.syntax;

import java.util.Deque;
import model.MainModel;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

public class GroupStart implements SLogoExpression {

    @Override
    public void loadArguments (Deque<SLogoExpression> args) {
        while(!args.isEmpty()) {
            
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
}