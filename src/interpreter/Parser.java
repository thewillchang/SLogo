package interpreter;

import interpreter.expression.SLogoExpression;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
import model.MainModel;
import exceptions.SLogoParsingException;

/**
 * Parses the input and creates an SLogoExpression representing it
 * throws parsing exception if fails
 * @author Will Chang
 */
public class Parser {
    private final String spaceSplit = "\\s+";
    private final String comment = "#";
    private final String newline = "\n";
    private Deque<SLogoExpression> myParameterStack;
    private Deque<SLogoExpression> myLoadedExpressions;
    private SLogoExpressionFactory myFactory;

    /**
     * Constructor
     * @param library
     */
    public Parser (CommandReferenceLibrary library, MainModel model) {    
        myFactory = new SLogoExpressionFactory(library, model);     
        myParameterStack =  new ArrayDeque<>();
        myLoadedExpressions = new ArrayDeque<>();
    }

    /**
     * Reads expression from back, parsing using a stack and returns list of expressions to evaluate
     * @param input String read from frontend
     * @return a deque of SLogoExpressions to evaluate 
     * @throws SLogoParsingException if invalid input
     */
    public Deque<SLogoExpression> parseSLogoExpression (String input) 
            throws SLogoParsingException, NoSuchElementException {
        String filteredInput = parseOutComments(input);
        Deque<SLogoExpression> expressionStack = makeExpressionsFromInput(processInput(filteredInput));
        loadAllExpressionParameters(expressionStack);
        return myLoadedExpressions;
    }

    /**
     * Calls Factory to create all SLogoExpressions from user input
     * @param processedInputStack processed String deque
     * @return Deque of SLogoExpressions
     * @throws SLogoParsingException
     */
    private Deque<SLogoExpression> makeExpressionsFromInput (Deque<String> processedInputStack) 
            throws SLogoParsingException, NullPointerException {
        while (!processedInputStack.isEmpty()) {
            String input = processedInputStack.pop();
            myParameterStack.push(myFactory.createExpression(input));
        }
        return myParameterStack;
    }

    /**
     * Processes initial String input
     * @param input String from frontend
     * @return Deque of all potential user specified commands
     */
    private Deque<String> processInput (String input) {
        List<String> processedInputs = Arrays.asList(input.toLowerCase().split(spaceSplit));
        return new ArrayDeque<>(processedInputs);
    }

    /**
     * Loads all parameters into all generated expressions.
     * @param expressionStack
     */
    private void loadAllExpressionParameters (Deque<SLogoExpression> expressionStack) 
            throws SLogoParsingException, NoSuchElementException {
        myLoadedExpressions = new ArrayDeque<>(); 
        while (!expressionStack.isEmpty()) {
            SLogoExpression expression = expressionStack.pop();
            expression.loadArguments(myLoadedExpressions);
            myLoadedExpressions.push(expression);
        }
    }

    /**
     * Removes comments from the string
     * @param input string
     * @return string without comments
     */
    private String parseOutComments (String input) {
        List<String> lines = new ArrayList<>(Arrays.asList(input.split(newline)));
        List<String> filteredLines = new ArrayList<>();
        for (String line : lines) {
            if (!line.trim().startsWith(comment)) {
                filteredLines.add(line.trim());
            }
        }
        return String.join(" ", filteredLines);
    }
}