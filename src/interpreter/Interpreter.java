package interpreter;

import interpreter.expression.SLogoExpression;
import interpreter.result.ErrorResult;
import interpreter.result.SLogoResult;
import java.util.Deque;
import java.util.NoSuchElementException;
import model.MainModel;
import exceptions.SLogoParsingException;

/**
 * Interprets and processes user input, sending results to the model
 * 
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
    public Interpreter (MainModel model) {
        myModel = model;
        myLibrary = new CommandReferenceLibrary(model.getLanguage(),
                                                model.getUserDefinedMethods(), 
                                                model.getUserDefinedVariables());
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
            return myEvaluator.evaluateExpressionsAndMerge(parsedExpressions);
        }
        catch (SLogoParsingException | NoSuchElementException | NullPointerException e) {
            return new ErrorResult(e);
        }
    }

    /**
     * Set the language
     * @param language
     */
    public void setLanguage (String language) {
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
