package interpreter.expression.userdefined;

import java.util.Deque;
import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

public class DoTimes implements SLogoExpression {
    
    //DOTIMES [ variable limit ]
     //       [ command(s) ]  runs the commands for each value specified in the range, i.e., from (1 - limit) inclusive 
       //     note, variable is assigned to each succeeding value so that it can be accessed by the commands
    
    @Override
    public void loadArguments (Deque<SLogoExpression> args) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public SLogoResult evaluate () {
        // TODO Auto-generated method stub
        return null;
    }
}