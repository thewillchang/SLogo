package interpreter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import exceptions.SLogoParsingException;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SLogoExpressionFactory;

/**
 * Interprets and processes user input, sending results to the model
 * @author Will Chang
 *
 */
public class Interpreter {

    
    //TODO check if needed for future implementations...
    private Map<String, List<String>> commandMap;
    private Set<String> commandSet;
    
    //TODO check if this map setup is good for all implementations...
    private Map<String, String> referenceToCommandMap;
    
    private Parser myParser;
    private ResourceBundle myCommandReference; 
    
    private final String DEFAULT_LANGUAGE = "English";


    /**
     * Constructor
     */
    public Interpreter() {
        myParser = new Parser();
        
        commandSet = new HashSet<>();
        commandMap = new HashMap<>();
        referenceToCommandMap = new HashMap<>();
        setCommandReference(DEFAULT_LANGUAGE);
        
    }


    /**
     * interprets an SLogo command and returns an SLogo result
     * @param command 
     * @return
     */
    public SLogoResult interpret(String input) {
        try {
            Collection<SLogoExpression> parsedExpressions = myParser.parseSLogoExpression(input);
            
            return null;
        }
        catch (SLogoParsingException e) {
            // TODO update without printing stack trace
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Sets the Reference Language for SLogo Commands
     * @param language to set to.
     */
    private void setCommandReference(String language) {
        myCommandReference = ResourceBundle.getBundle("resources.languages." + language, Locale.US);
        commandSet = myCommandReference.keySet();
        for(String command : commandSet) {
            List<String> commandReferences = Arrays.asList(myCommandReference.getString(command).split(","));
            commandMap.put(command, commandReferences);
            for(String reference : commandReferences) {
                referenceToCommandMap.put(reference,command);
                
            }
            
        }
    }
    
    public static void main(String[] args) throws SLogoParsingException {
        Interpreter interpreter = new Interpreter();
        
        
    }


}
