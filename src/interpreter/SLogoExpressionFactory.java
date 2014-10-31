package interpreter;

import interpreter.expression.*;
import java.util.Map;
import model.MainModel;
import exceptions.SLogoParsingException;

/**
 * factory for creating an SLogoExpression for a given string
 * throws exception for unimplemented or nonexistent method names
 * @author Will Chang
 *
 */
public class SLogoExpressionFactory {

    private final String myClassPath = "interpreter.expression.";

    private Map<String, String> myReferenceToCommandMap;
    private Map<String, String> myReverseSyntaxMap;
    private Map<String, String> myCommandToDirectoryMap;
    private Map<String, Integer> myCommandToNumArgsMap;

    private CommandReferenceLibrary myLibrary;
    private MainModel myModel;

    private enum stringType {
        REGEX, NORMAL
    }

    /**
     * Constructor
     * @param library
     */
    public SLogoExpressionFactory (CommandReferenceLibrary library, MainModel model) {
        myModel = model;
        myLibrary = library;
        myReferenceToCommandMap = myLibrary.getReferencesToCommands();
        myReverseSyntaxMap = myLibrary.getReverseSyntaxes();
        myCommandToDirectoryMap = myLibrary.getCommandsToDirectories();
        myCommandToNumArgsMap = myLibrary.getCommandsToNumArgs();   
    }

    /**
     * creates an SLogoExpression based on given command string
     * throws parsing exception if no command exists for given string
     * @param command
     * @return
     * @throws ParsingException
     */
    public SLogoExpression createExpression (String command) throws SLogoParsingException {
        SLogoExpression expression = checkTypeAndInitialize(command, myReferenceToCommandMap, stringType.NORMAL);
        return (expression == null) ? checkTypeAndInitialize(command, myReverseSyntaxMap, stringType.REGEX) : expression;
    }

    /**
     * Checks whether the type of input is a predefined command or 
     * a regex and initializes the expression
     * using reflection
     * @param command the command's name the user inputted
     * @param referenceMap the map which holds the type of references to check
     * @param type the type of input it is
     * @return the desired SLogoExpression
     */
    private SLogoExpression checkTypeAndInitialize (String command, 
                                                    Map<String, String> referenceMap, 
                                                    stringType type) throws SLogoParsingException {
        for (String reference : referenceMap.keySet()) {
            if (isMatch(command, reference, type)) {
                try {
                    String name = referenceMap.get(reference);
                    String classPathAndName = 
                            myClassPath
                            + myCommandToDirectoryMap.get(name)
                            + name;
                    Class<?> commandClass = Class.forName(classPathAndName);
                    SLogoExpression expression = (SLogoExpression)commandClass.newInstance();
                    initializeExpression(expression, name);
                    expression.setValue(command);
                    return expression;
                }
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                   return new ErrorExpression(e);
                }               
            }
        }
        return null;
    }

    /**
     * Checks the type of the Command and returns the proper 
     * @param command
     * @param reference
     * @param type
     * @return
     */
    private boolean isMatch (String command, String reference, stringType type) {
        return (stringType.NORMAL == type) ? command.equals(reference) : command.matches(reference);
    }

    /**
     * Initializes the parameters of the Expression.
     * @param expression to initialize
     * @param name of the expression
     */
    private void initializeExpression (SLogoExpression expression, String name) {
        expression.setNumArgs(myCommandToNumArgsMap.get(name));
        expression.loadLibrary(myLibrary);
        expression.loadModel(myModel);
    }
}
