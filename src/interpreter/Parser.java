package interpreter;

import interpreter.expression.SLogoExpression;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import exceptions.SLogoParsingException;

/**
 * class that parses the input and creates an SLogoExpression representing it
 * throws parsing exception if fails
 * @author Will Chang
 *
 */
public class Parser {
    private Deque<SLogoExpression> parameterStack = new ArrayDeque<>();
    private Deque<SLogoExpression> loadedExpressions = new ArrayDeque<>();

    private SLogoExpressionFactory myFactory;
    private CommandReferenceLibrary myLibrary;

    /**
     * Constructor
     * @param library
     */
    public Parser(CommandReferenceLibrary library) {
        myLibrary = library;
        myFactory = new SLogoExpressionFactory(library);
    }

    /**
     * Reads expression from back, parsing using a stack and returns list of expressions to evaluate
     * @param input String read from frontend
     * @return a deque of SLogoExpressions to evaluate 
     * @throws SLogoParsingException if invalid input
     */
    public Deque<SLogoExpression> parseSLogoExpression (String input) throws SLogoParsingException {
        try {

            Deque<SLogoExpression> expressionStack = createExpressionsFromProcessedInput(processInput(input));
            loadAllExpressionParameters(expressionStack);

        }
        catch (SLogoParsingException e) {
            System.out.println("Invalid Input");
        }
        return loadedExpressions;
    }

    /**
     * Calls Factory to create all SLogoExpressions from user input
     * @param processedInputStack processed String deque
     * @return Deque of SLogoExpressions
     * @throws SLogoParsingException
     */
    private Deque<SLogoExpression> createExpressionsFromProcessedInput (Deque<String> processedInputStack) 
            throws SLogoParsingException {
        while(!processedInputStack.isEmpty()) {
            //feeds inorder into Factory, gets reverse ordered stack?...
            String input = processedInputStack.pop();
            parameterStack.push(myFactory.createExpression(input));
            if(input.equals("to")) {
                try {
                    String undefinedCommand = processedInputStack.pop();
                    parameterStack.push(myFactory.defineUserCommand(undefinedCommand));
                }
                catch (NullPointerException e) {
                    System.out.println("Failed to specify sufficient parameters.");
                    parameterStack.clear();
                }
            }

        }
        return parameterStack;
    }

    /**
     * Processes initial String input
     * @param input String from frontend
     * @return Deque of all potential user specified commands
     */
    private Deque<String> processInput(String input) {
        List<String> processedInputs = Arrays.asList(input.toLowerCase().split("\\s+"));
        //Collections.reverse(processedInputs);
        return new ArrayDeque<>(processedInputs);
    }

    /**
     * Loads all parameters into all generated expressions.
     * @param expressionStack
     */
    private void loadAllExpressionParameters(Deque<SLogoExpression> expressionStack) {
        loadedExpressions = new ArrayDeque<>(); 
        while (!expressionStack.isEmpty()) {
            SLogoExpression expression = expressionStack.pop();
            expression.loadArguments(loadedExpressions);
            loadedExpressions.push(expression);
        }

    }



    /*

    public static void main(String[] args) throws SLogoParsingException {
        Parser p = new Parser();
        String input = "forward 50";
        p.parseSLogoExpression(input);
    }

     */

}
