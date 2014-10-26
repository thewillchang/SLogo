package interpreter;


import java.util.Deque;
import model.MainModel;
import exceptions.SLogoParsingException;
import interpreter.expression.SLogoExpression;
import interpreter.result.SLogoResult;


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
        myLibrary = new CommandReferenceLibrary(model.getLanguage(), 
                                                model.getUserDefinedMethods(), 
                                                model.getUserDefinedVariables());
        myParser = new Parser(myLibrary, model);
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

    /**
     * Sets the language of the Interpreter/Library
     * @param language to be set
     */
    public void setLanguage(String language) {
        myLibrary.setLanguageAndReferences(language);
    }
    
    /**
     * Gets the Library
     * @return myCommandReferenceLibrary
     */
    public CommandReferenceLibrary getCommandReferenceLibrary () {
        return myLibrary;
    }
}
