package interpreter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
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
    
    private Parser myParser;
    
    /**
     * Constructor
     */
    public Interpreter() {
        myParser = new Parser();
        
    }


    /**
     * interprets an SLogo command and returns an SLogo result
     * @param command 
     * @return
     */
    public SLogoResult interpret(String input) {
        try {
            Deque<SLogoExpression> parsedExpressions = myParser.parseSLogoExpression(input);
            while(!parsedExpressions.isEmpty()) {
                
            }
            return null;
        }
        catch (SLogoParsingException e) {
            // TODO update without printing stack trace
            e.printStackTrace();
            return null;
        }
    }
    

    
    public static void main(String[] args) throws SLogoParsingException {
        Interpreter interpreter = new Interpreter();
        
        
    }


}
