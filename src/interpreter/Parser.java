package interpreter;

import interpreter.expression.SLogoExpression;
import interpreter.expression.SLogoExpressionFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import exceptions.SLogoParsingException;

/**
 * class that parses the input and creates an SLogoExpression representing it
 * throws parsing exception if fails
 * @author Will Chang and Jonathan Tseng
 *
 */
public class Parser {

    private SLogoExpressionFactory myFactory;
    private Deque<SLogoExpression> expressionStack = new ArrayDeque<>();
    private Deque<SLogoExpression> parameterStack = new ArrayDeque<>();
    

    public Parser() {
        myFactory = new SLogoExpressionFactory("English");
    }
    /**
     * reads expression from back, parsing using a stack and returns list of expressions to evaluate
     * @param input
     * @return
     * @throws SLogoParsingException
     */
    public Collection<SLogoExpression> parseSLogoExpression (String input) throws SLogoParsingException {
        createExpressionsFromProcessedInput(processInput(input));
        return null;
    }

    private Deque<String> processInput(String input) {
        List<String> processedInputs = Arrays.asList(input.split("\\s+"));
        Collections.reverse(processedInputs);
        return new ArrayDeque<>(processedInputs);
    }

    private Collection<SLogoExpression> createExpressionsFromProcessedInput (Deque<String> processedInputStack) 
            throws SLogoParsingException {

        while(!processedInputStack.isEmpty()) {
            String input = processedInputStack.pop();
            parameterStack.push(myFactory.createExpression(input));
        }
        return parameterStack;
    }

    public static void main(String[] args) throws SLogoParsingException
    {
        Parser p = new Parser();
        String input = "forward";
        p.parseSLogoExpression(input);
       // System.out.println(p.parameterStack.size());
    }

}
