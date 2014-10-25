package interpreter.expression.userdefined;

import interpreter.SLogoResult;
import interpreter.UserDefinedResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;
import interpreter.expression.syntax.Command;
import java.util.Arrays;
import java.util.List;
import model.UserDefinedCommandsModel;

/**
 * 
 * @author Will Chang
 *
 */

public class MakeUserInstruction extends UserDefinedExpression {

    
    //TODO Error check improperly definedmethod names... check for preexisting methods
    @Override
    public SLogoResult evaluate () {
        String name = myArguments.pop().evaluate().toString();
        List<String> variables = Arrays.asList(myArguments.pop().evaluate().toString().split("\\|"));
        SLogoExpression commands = myArguments.pop();
        
        UserDefinedCommandsModel definedCommandsModel = myLibrary.getUserDefinedCommands();
        definedCommandsModel.put(name, new Command(name, commands));
        definedCommandsModel.setVariablesforCommand(name, variables);
        if(definedCommandsModel.containsCommand(name)) {
        return new UserDefinedResult(1);
        }
        return new UserDefinedResult(0);
    }
    
    @Override
    public void setValue (String value) {
    }


}
