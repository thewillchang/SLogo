package interpreter;

import interpreter.expression.SLogoExpression;
import interpreter.expression.SLogoExpressionFactory;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import exceptions.SLogoParsingException;

/**
 * class that parses the input and creates an SLogoExpression representing it
 * throws parsing exception if fails
 * @author Will Chang and Jonathan Tseng
 *
 */
public class Parser {

    private SLogoExpressionFactory myFactory;
    private Deque<SLogoExpression> parameterStack = new ArrayDeque<>();
    private Deque<SLogoExpression> loadedExpressions = new ArrayDeque<>();

    public Parser() {
        myFactory = new SLogoExpressionFactory("English");
    }
    /**
     * reads expression from back, parsing using a stack and returns list of expressions to evaluate
     * @param input
     * @return
     * @throws SLogoParsingException
     */
    public Deque<SLogoExpression> parseSLogoExpression (String input) throws SLogoParsingException {
        try{
        Deque<SLogoExpression> expressionStack = createExpressionsFromProcessedInput(processInput(input));
        loadAllExpressionParameters(expressionStack);
        }
        catch (SLogoParsingException e) {
            System.out.println("Invalid Input");
        }
        return loadedExpressions;
    }

    private void loadAllExpressionParameters(Deque<SLogoExpression> expressionStack) {
        loadedExpressions = new ArrayDeque<>(); 
        while (!expressionStack.isEmpty()) {
            SLogoExpression expression = expressionStack.pop();
            expression.loadArguments(expressionStack);
            loadedExpressions.push(expression);
        }
        
    }
    
    private Deque<String> processInput(String input) {
        //TODO check with Team/in future implementations for checking everything in as lowercase...
        List<String> processedInputs = Arrays.asList(input.toLowerCase().split("\\s+"));
        Collections.reverse(processedInputs);
        return new ArrayDeque<>(processedInputs);
    }

    private Deque<SLogoExpression> createExpressionsFromProcessedInput (Deque<String> processedInputStack) 
            throws SLogoParsingException {
        while(!processedInputStack.isEmpty()) {
            String input = processedInputStack.pop();
            parameterStack.push(myFactory.createExpression(input));
        }
        return parameterStack;
    }

    public static void main(String[] args) throws SLogoParsingException {
        Parser p = new Parser();
        String input = "forward 50";
        p.parseSLogoExpression(input);
    }

}
