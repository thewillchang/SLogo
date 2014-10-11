package interpreter;


import java.util.Deque;

import exceptions.SLogoParsingException;
import interpreter.expression.SLogoExpression;


/**
 * Interprets and processes user input, sending results to the model
 * @author Will Chang
 *
 */
public class Interpreter {

    private Parser myParser;
    private ExpressionEvaluator myEvaluator;

    /**
     * Constructor
     */
    public Interpreter() {
        myParser = new Parser();
        myEvaluator = new ExpressionEvaluator();
    }


    /**
     * interprets an SLogo command and returns an SLogo result
     * @param command 
     * @return
     */
    public SLogoResult interpret(String input) {
        try {
            Deque<SLogoExpression> parsedExpressions = myParser.parseSLogoExpression(input);
            return myEvaluator.evaluateExpressionsAndMergeResults(parsedExpressions);
        }
        catch (SLogoParsingException e) {
            // TODO update without printing stack trace
            System.out.println("Invalid Input");
        }
        return null;
    }



    public static void main(String[] args) throws SLogoParsingException {
        Interpreter interpreter = new Interpreter();
        String input = "forward 50";
        String input_error = "asdf";
        System.out.println(interpreter.interpret(input).getTransition().size());
        //interpreter.interpret(input_error);
    }


}
