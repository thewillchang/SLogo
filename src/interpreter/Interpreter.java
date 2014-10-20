package interpreter;


import java.util.Deque;
import model.MainModel;
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
    private CommandReferenceLibrary myLibrary;
    private MainModel myModel;

    /**
     * Constructor
     */
    public Interpreter(MainModel model) {
        myModel = model;
        myLibrary = new CommandReferenceLibrary();
        myParser = new Parser(myLibrary, myModel);
        myEvaluator = new ExpressionEvaluator();
    }


    /**
     * Interprets user input, parses into SLogoExpressions, and returns an SLogo result
     * @param command 
     * @return
     */
    public SLogoResult interpret (String input) {
        try {
            Deque<SLogoExpression> parsedExpressions = myParser.parseSLogoExpression(input);
            return myEvaluator.evaluateExpressionsAndMergeResults(parsedExpressions);
        }
        catch (SLogoParsingException e) {
            System.out.println("Invalid Input");
        }
        return null;
    }

    public void setLogoLanguage(String language) {
        myLibrary = new CommandReferenceLibrary(language);
        myParser = new Parser(myLibrary, myModel);
    }
    
    public CommandReferenceLibrary getCommandReferenceLibrary () {
        return myLibrary;
    }

    public static void main(String[] args) throws SLogoParsingException {
        Interpreter interpreter = new Interpreter(new MainModel());
        String input = "forward forward 50";
        CommandReferenceLibrary lib = interpreter.getCommandReferenceLibrary();
        System.out.println(interpreter.interpret(input).getTransition().size());
    }


}
