package interpreter;

import interpreter.expression.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import model.MainModel;
import model.UserDefinedCommandsModel;
import model.UserDefinedVariablesModel;
import exceptions.SLogoParsingException;

/**
 * factory for creating an SLogoExpression for a given string
 * throws exception for unimplemented or nonexistent method names
 * @author Will Chang
 *
 */
public class SLogoExpressionFactory {

    private final String CLASS_PATH = "interpreter.expression.";
    
    private Map<String,String> myReferenceToCommandMap;
    private Map<String,String> myReverseSyntaxMap;
    private Map<String,String> myCommandToDirectoryMap;
    private Map<String,Integer> myCommandToNumArgsMap;
    
    private UserDefinedCommandsModel myUserDefinedCommands;
    private UserDefinedVariablesModel myUserDefinedVariables;
    private Set<String> mySyntaxSet;

    private CommandReferenceLibrary myLibrary;
    private MainModel myModel;
    
    private enum StringType {
        REGEX, NORMAL
    }

    /**
     * Constructor
     * @param library
     */
    public SLogoExpressionFactory (CommandReferenceLibrary library, MainModel model) {
        myModel = model;
        myLibrary = library;
        setupLocalLibrary();
    }

    /**
     * Initializes maps.
     */
    protected void setupLocalLibrary() {
        myReferenceToCommandMap = myLibrary.getReferencesToCommands();
        myReverseSyntaxMap = myLibrary.getReverseSyntaxes();
        myCommandToDirectoryMap = myLibrary.getCommandsToDirectories();
        myCommandToNumArgsMap = myLibrary.getCommandsToNumArgs();
        myUserDefinedCommands = myLibrary.getUserDefinedCommands();
        myUserDefinedVariables = myLibrary.getUserDefinedVariables();
        mySyntaxSet = myLibrary.getSyntaxSet();
    }
    
    /**
     * creates an SLogoExpression based on given command string
     * throws parsing exception if no command exists for given string
     * @param command
     * @return
     * @throws ParsingException
     */
    public SLogoExpression createExpression (String command) throws SLogoParsingException {
        SLogoExpression expression = checkTypeAndInitialize(command, myReferenceToCommandMap, StringType.NORMAL);
        return (expression == null) ? checkTypeAndInitialize(command, myReverseSyntaxMap, StringType.REGEX) : expression;
    }

    private SLogoExpression checkTypeAndInitialize(String command, 
                                               Map<String, String> referenceMap, StringType type) {
        for(String reference : referenceMap.keySet()) {
            if(isMatch(command, reference, type)) {
                try {
                    String name = referenceMap.get(reference);
                    String classPathAndName = 
                            CLASS_PATH 
                            + myCommandToDirectoryMap.get(name)
                            + name;
                    Class<?> commandClass = Class.forName(classPathAndName);
                    SLogoExpression expression = (SLogoExpression) commandClass.newInstance();
                    initializeExpression(expression, name);
                    expression.setValue(command);
                    return expression;
                }
                catch (ClassNotFoundException e) {
                    System.out.println("No such class.");
                } 
                catch (InstantiationException e) {
                    System.out.println("Failed to Instantiate");
                } 
                catch (IllegalAccessException e) {
                    System.out.println("Illegal Access");
                }
            }
        }
        return null;
    }

    private boolean isMatch(String command, String reference, StringType type) {
        if(StringType.NORMAL == type) {
            return command.equals(reference);
        }
        return command.matches(reference);
    }
    
    private void initializeExpression(SLogoExpression expression, String name) {
        expression.setNumArgs(myCommandToNumArgsMap.get(name));
        expression.loadLibrary(myLibrary);
        expression.loadModel(myModel);
    }

    public SLogoExpression defineUserCommand(String command) throws SLogoParsingException {
        //TODO define user defined commands, also refactor for lists etc.
        return null;
    }

    public static void main(String[] args) throws SLogoParsingException {   
        HashMap<String,String> asdf = new HashMap<>();
        asdf.put("asdf","asdf");
        System.out.println(asdf.containsKey("asdf"));
        System.out.println(asdf.containsKey("a"));
       /* SLogoExpressionFactory factory = new SLogoExpressionFactory(new CommandReferenceLibrary(), new MainModel());
        ResourceBundle mySyntaxReference = ResourceBundle.getBundle("resources.languages.Syntax", Locale.US);
        mySyntaxReference.getString("ListStart");
        System.out.println("[".matches(mySyntaxReference.getString("ListStart")));*/
        
    }
}
