package interpreter;


import interpreter.expression.SLogoExpression;
import interpreter.result.SLogoResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

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
	public Interpreter(MainModel model) {
		myModel = model;
		myLibrary = new CommandReferenceLibrary(model.getLanguage(),
				model.getUserDefinedMethods(), model.getUserDefinedVariables());
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
        	String filteredInput = parseOutComments(input);
            Deque<SLogoExpression> parsedExpressions = myParser.parseSLogoExpression(filteredInput);
            return myEvaluator.evaluateExpressionsAndMergeResults(parsedExpressions);
        }
        catch (SLogoParsingException e) {
			myModel.setErrorMessage("Invalid input - parsing error");
        }
        return null;
    }
   
    private String parseOutComments(String input) {
    	List<String> lines = new ArrayList<>(Arrays.asList(input.split("\n")));
    	List<String> filteredLines = new ArrayList<>();
    	for (String line : lines) {
    		if (!line.trim().startsWith("#")) {
    			filteredLines.add(line.trim());
    		}
    	}
    	return String.join(" ", filteredLines);
    }
    
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
