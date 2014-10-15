package interpreter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
/**
 * Holds references to Syntax etc.
 * @author Will Chang
 *
 */

public class CommandReferenceLibrary {

    //private Map<Pattern, String> patternsToCommandMap;
    private Map<String, String> referenceToCommandMap;


    private final String COMMENT = "\\#"; 
    private final String CONSTANT = "-?[0-9]+\\.?[0-9]*";
    private final String VARIABLE = ":[a-zA-z]+";
    private final String COMMAND = "[a-zA-z_]+(\\?)?";
    private final String LIST_START = "\\[";
    private final String LIST_END = "\\]";
    private final String GROUP_START = "\\(";
    private final String GROUP_END = "\\)";

    //Deprecated
    //private Map<String, List<String>> commandMap;
    private Set<String> commandSet;
    private Set<String> directorySet;

    private Map<String,String> syntaxMap;
    private Map<String,String> reverseSyntaxMap;
    private Map<String,String> commandToDirectoryMap;



    private ResourceBundle myCommandReference; 
    private ResourceBundle myDirectoryListing;


    //private final String DEFAULT_LANGUAGE = "English";


    public CommandReferenceLibrary () {
        this("English");
    }

    protected CommandReferenceLibrary(String language) {

        commandSet = new HashSet<>();
        //commandMap = new HashMap<>();
        referenceToCommandMap = new HashMap<>();

        directorySet = new HashSet<>();
        commandToDirectoryMap = new HashMap<>();

        //Initializes syntaxMap
        initializeSyntaxMap(); 
        setCommandReference(language);
    }
    
    protected void addUserDefinedCommand(String command) {
        return;
    }
    
    protected Map<String,String> getReferencesToCommands() {
        return referenceToCommandMap;
    }
    
    protected Map<String,String> getCommandsToDirectories() {
        return commandToDirectoryMap;
    }
    
    protected Map<String,String> getReverseSyntaxes() {
        return reverseSyntaxMap;
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
        
        reverseSyntaxMap = new HashMap<>();
        reverseSyntaxMap.put(COMMENT,"Comment");
        reverseSyntaxMap.put(CONSTANT, "Constant");
        reverseSyntaxMap.put(VARIABLE, "Variable");
        reverseSyntaxMap.put(COMMAND, "Command");
        reverseSyntaxMap.put(LIST_START, "ListStart");
        reverseSyntaxMap.put(LIST_END, "ListEnd");
        reverseSyntaxMap.put(GROUP_START, "GroupStart");
        reverseSyntaxMap.put(GROUP_END, "GroupEnd");
    }
    
    /**
     * Sets the Reference Language for SLogo Commands
     * @param language to set to.
     */
    private void setCommandReference (String language) {
        myCommandReference = ResourceBundle.getBundle("resources.languages." + language, Locale.US);
        myDirectoryListing = ResourceBundle.getBundle("resources.languages.DirectoryListing", Locale.US);
        
        commandSet = myCommandReference.keySet();
        directorySet = myDirectoryListing.keySet();
        Set<String> syntaxSet = syntaxMap.keySet();
        
        //SpecialRegex...
        String specialRegex = "[^A-Za-z0-9]";
        for(String command : commandSet) {
            //Tempory fix for special characters from syntax set
            if(!syntaxSet.contains(command)) {
                List<String> commandReferences = Arrays.asList(myCommandReference.getString(command).split(","));
                //for CommandMap
                //commandMap.put(command, commandReferences);

                for(String reference : commandReferences) {
                    if(reference.matches(specialRegex)) {
                        reference = "\\" + reference;
                    }
                    referenceToCommandMap.put(reference,command);
                }
            }

        }
        
        for(String directory : directorySet) {
                List<String> directoryReferences = Arrays.asList(myDirectoryListing.getString(directory).split(","));
                for(String reference : directoryReferences) {
                    commandToDirectoryMap.put(reference,directory);    
                }
        }
    }
    

}
