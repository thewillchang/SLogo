package interpreter.expression.userdefined;
import interpreter.expression.SLogoExpression;
import interpreter.expression.UserDefinedExpression;
import interpreter.expression.syntax.ListEnd;
import interpreter.result.SLogoResult;
import interpreter.result.SyntaxResult;
import interpreter.result.UserDefinedResult;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import model.UserDefinedCommandsModel;
/**
 * 
 * @author Will Chang
 *
 */
public class MakeUserInstruction extends UserDefinedExpression {
    
    @Override
    public SLogoResult evaluate () {
        String name = myArguments.pop().evaluate().toString();
        Deque<SLogoExpression> variableExpressions = ((SyntaxResult) myArguments.pop().evaluate()).getGroupedExpressions();
        List<String> variables = new ArrayList<>();
        for(SLogoExpression expression : variableExpressions) {
            if(!(expression instanceof ListEnd)) {
                variables.add(expression.getValue());
            }
        }
        SLogoExpression commands = myArguments.pop();
        UserDefinedCommandsModel definedCommandsModel = myLibrary.getUserDefinedCommands();
        definedCommandsModel.putCommand(name, commands);
        definedCommandsModel.setVariablesForCommand(name, variables);
        if(definedCommandsModel.containsCommand(name)) {
            return new UserDefinedResult(1);
        }
        return new UserDefinedResult(0);
    }
}