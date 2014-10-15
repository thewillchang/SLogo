package interpreter;

import interpreter.expression.*;
import interpreter.expression.syntax.*;
import java.util.Map;
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
    private CommandReferenceLibrary myLibrary;

    private final String CLASS_PATH = "interpreter.expression.";
    
    /**
     * Constructor
     * @param library
     */
    public SLogoExpressionFactory (CommandReferenceLibrary library) {
        myLibrary = library;
        setMapsFromLibrary();
    }

    /**
     * Initializes maps.
     */
    protected void setMapsFromLibrary() {
        myReferenceToCommandMap = myLibrary.getReferencesToCommands();
        myReverseSyntaxMap = myLibrary.getReverseSyntaxes();
        myCommandToDirectoryMap = myLibrary.getCommandsToDirectories();
    }
    
    private SLogoExpression checkExpressionTypeAndGenerate(String command, 
                                                Map<String, String> referenceMap) 
                                                        throws SLogoParsingException {
        
        for(String reference : referenceMap.keySet()) {
            if(command.matches(reference)) {
                try {
                    String expressionName = referenceMap.get(reference);
                    String classPathAndName = 
                            CLASS_PATH 
                            + myCommandToDirectoryMap.get(expressionName)
                            + expressionName;
                    Class<?> commandClass = Class.forName(classPathAndName);
                    return (SLogoExpression) commandClass.newInstance();
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
        throw new SLogoParsingException("Command not found");
    }

    /**
     * creates an SLogoExpression based on given command string
     * throws parsing exception if no command exists for given string
     * @param command
     * @return
     * @throws ParsingException
     */
    public SLogoExpression createExpression (String command) throws SLogoParsingException {
        SLogoExpression expression = checkExpressionTypeAndGenerate(command, myReferenceToCommandMap);
        return (expression == null) ? checkExpressionTypeAndGenerate(command, myReverseSyntaxMap) : expression;
    }

    public SLogoExpression defineUserCommand(String command) throws SLogoParsingException {
        //TODO define user defined commands, also refactor for lists etc.
        return null;
    }
    
  
/*
    public static void main(String[] args) throws SLogoParsingException
    {

        Pattern pattern = Pattern.compile("[a-zA-z_]+(\\?)?");
        SLogoExpressionFactory factory = new SLogoExpressionFactory();


        System.out.println(pattern.matches("[A-Za-z0-9]","0"));
        //String temp = "[a-zA-z_]+(\?)?";
        System.out.println("*".matches("[^A-Za-z0-9]"));
        // System.out.println(p.parameterStack.size());
    }
*/

}
