package interpreter.expression.syntax;

import java.util.Deque;
import exceptions.SLogoParsingException;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

public class Command implements SLogoExpression{

    @Override
    public void loadArguments (Deque<SLogoExpression> args) throws SLogoParsingException,
                                                           NullPointerException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public SLogoResult evaluate () {
        // TODO Auto-generated method stub
        return null;
    }

}
