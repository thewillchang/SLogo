package interpreter.expression;

import interpreter.Parser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;
import exceptions.SLogoParsingException;

/**
 * factory for creating an SLogoExpression for a given string
 * throws exception for unimplemented or nonexistent method names
 * @author Will Chang and Jonathan Tseng
 *
 */
public class SLogoExpressionFactory {

    private Map<Pattern, String> patternsToCommandMap;
    private Map<String, String> referenceToCommandMap;

    private final String DEFAULT_LANGUAGE = "English";

    private final String COMMENT = "\\#"; 
    private final String CONSTANT = "-?[0-9]+\\.?[0-9]*";
    private final String VARIABLE = ":[a-zA-z]+";
    private final String COMMAND = "[a-zA-z_]+(\\?)?";
    private final String LIST_START = "\\[";
    private final String LIST_END = "\\]";
    private final String GROUP_START = "\\(";
    private final String GROUP_END = "\\)";


    //Deprecated
    private Map<String, List<String>> commandMap;
    private Set<String> commandSet;

    private Map<String,String> syntaxMap;

    private final String CLASS_PATH = "interpreter.expression.";


    private ResourceBundle myCommandReference; 

    public SLogoExpressionFactory (String language) {
        // TODO Auto-generated constructor stub
        commandSet = new HashSet<>();
        commandMap = new HashMap<>();
        referenceToCommandMap = new HashMap<>();

        //Initializes syntaxMap
        initializeSyntaxMap();

        setCommandReference(language);
    }

    //TODO temp fix, will refactor
    private void initializeSyntaxMap () {
        syntaxMap = new HashMap<>();
        syntaxMap.put("Comment",COMMENT);
        syntaxMap.put("Constant",CONSTANT);
        syntaxMap.put("Variable",VARIABLE);
        syntaxMap.put("Command",COMMAND);
        syntaxMap.put("ListStart",LIST_START);
        syntaxMap.put("ListEnd",LIST_END);
        syntaxMap.put("GroupStart",GROUP_START);
        syntaxMap.put("GroupEnd",GROUP_END);
    }

    /**
     * creates an SLogoExpression based on given command string
     * throws parsing exception if no command exists for given string
     * @param command
     * @return
     * @throws ParsingException
     */
    public SLogoExpression createExpression (String command) throws SLogoParsingException {
        for(String reference : referenceToCommandMap.keySet()) {
            if(command.matches(reference)) {
                System.out.println(command);    
                try {
                    String classPathAndName = 
                            CLASS_PATH
                            + referenceToCommandMap.get(reference);
                    Class<?> commandClass = Class.forName(classPathAndName);
                    return (SLogoExpression) commandClass.newInstance();
                }
                catch (ClassNotFoundException e) {
                    System.out.println("No such class.");
                } catch (InstantiationException e) {
                    System.out.println("Failed to Instantiate");
                } catch (IllegalAccessException e) {
                    System.out.println("Illegal Access");
                }
            }

        }
        throw new SLogoParsingException("asdf");
    }

    /**
     * Sets the Reference Language for SLogo Commands
     * @param language to set to.
     */
    private void setCommandReference (String language) {
        myCommandReference = ResourceBundle.getBundle("resources.languages." + language, Locale.US);
        commandSet = myCommandReference.keySet();
        Set<String> syntaxSet = syntaxMap.keySet();
        for(String command : commandSet) {

            if(!syntaxSet.contains(command)) {
                List<String> commandReferences = Arrays.asList(myCommandReference.getString(command).split(","));
                //for CommandMap
                //commandMap.put(command, commandReferences);

                for(String reference : commandReferences) {
                    referenceToCommandMap.put(reference,command);
                }
            }
        }
        /*for(String s : commandMap.get("Quotient")) {
            System.out.println("divide".matches(s));        
        }*/

    }

    public static void main(String[] args) throws SLogoParsingException
    {

        Pattern pattern = Pattern.compile("[a-zA-z_]+(\\?)?");
        SLogoExpressionFactory factory = new SLogoExpressionFactory("English");


        System.out.println(pattern.matches("[A-Za-z0-9]","0"));
        //String temp = "[a-zA-z_]+(\?)?";
        System.out.println("q".equals("[A-Za-z0-9]"));
        // System.out.println(p.parameterStack.size());
    }


}
