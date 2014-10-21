package interpreter;

import interpreter.expression.*;
import interpreter.expression.syntax.*;
import java.util.Map;
import java.util.Set;
import model.MainModel;
import exceptions.SLogoParsingException;

/**
 * factory for creating an SLogoExpression for a given string
 * throws exception for unimplemented or nonexistent method names
 * @author Will Chang
 *
 */
public class SLogoExpressionFactory {

    private Map<String,String> myReferenceToCommandMap;
    private Map<String,String> myReverseSyntaxMap;
    private Map<String,String> myCommandToDirectoryMap;
    private Map<String,Integer> myCommandToNumArgsMap;
    
    private Map<String,SLogoExpression> myUserDefinedCommandsMap;
    private Map<String,SLogoExpression> myUserDefinedVariablesMap;
    private Set<String> mySyntaxSet;

    private CommandReferenceLibrary myLibrary;
    private MainModel myModel;

    private final String CLASS_PATH = "interpreter.expression.";

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
        myUserDefinedCommandsMap = myLibrary.getUserDefinedCommands();
        myUserDefinedVariablesMap = myLibrary.getUserDefinedVariables();
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
        SLogoExpression expression = checkTypeAndInitialize(command, myReferenceToCommandMap);
        return (expression == null) ? checkTypeAndInitialize(command, myReverseSyntaxMap) : expression;
    }

    private SLogoExpression checkTypeAndInitialize(String command, 
                                               Map<String, String> referenceMap) {

        for(String reference : referenceMap.keySet()) {
            if(command.matches(reference)) {
                try {
                    String name = referenceMap.get(reference);

                    String classPathAndName = 
                            CLASS_PATH 
                            + myCommandToDirectoryMap.get(name)
                            + name;
                    Class<?> commandClass = Class.forName(classPathAndName);
                    SLogoExpression expression = (SLogoExpression) commandClass.newInstance();
                    initializeExpression(expression, name);
                    if(mySyntaxSet.contains(name)) {
                        ((SyntaxExpression) expression).setValue(command);
                    }
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
        SLogoExpressionFactory factory = new SLogoExpressionFactory(new CommandReferenceLibrary(), new MainModel());
        System.out.println("equal?".matches("equal?"));
    }
}
