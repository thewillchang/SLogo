package interpreter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import model.UserDefinedCommandsModel;
import model.UserDefinedVariablesModel;

/**
 * Holds references to Syntax etc.
 * 
 * @author Will Chang
 *
 */

public class CommandReferenceLibrary {

    //private Map<Pattern, String> patternsToCommandMap;
    private Map<String, String> myReferenceToCommandMap;

    //Deprecated
    //private Map<String, List<String>> commandMap;
    private Set<String> myCommandSet;
    private Set<String> myDirectorySet;

    private Map<String,String> mySyntaxMap;
    private Map<String,String> myReverseSyntaxMap;
    private Map<String,String> myCommandToDirectoryMap;
    private Map<String, Integer> myCommandToNumArgsMap;

    private String myLanguage;

    private ResourceBundle myCommandReference; 
    private ResourceBundle myDirectoryListing;
    private ResourceBundle myNumberArguments;
    private ResourceBundle mySyntaxReference; 
    //TODO Refactor or delete... the functionality is the same as hashmap.....
    private UserDefinedCommandsModel myDefinedCommands;
    private UserDefinedVariablesModel myDefinedVariables;

    //private final String DEFAULT_LANGUAGE = "English";


    
    public CommandReferenceLibrary(String language, UserDefinedCommandsModel commandsModel,
                                   UserDefinedVariablesModel variablesModel) {
        myDirectoryListing = ResourceBundle.getBundle("resources.languages.DirectoryListing", Locale.US);
        myNumberArguments  = ResourceBundle.getBundle("resources.languages.NumberArguments", Locale.US);
        mySyntaxReference = ResourceBundle.getBundle("resources.languages.Syntax", Locale.US);

        
        myDefinedCommands = commandsModel;
        myDefinedVariables = variablesModel;
        
        

        myCommandSet = new HashSet<>();
        //commandMap = new HashMap<>();
        myReferenceToCommandMap = new HashMap<>();

        myDirectorySet = new HashSet<>();
        myCommandToDirectoryMap = new HashMap<>();
        myCommandToNumArgsMap = new HashMap<>();

        initializeSyntaxMap(); 
        setLanguageAndReferences(language);
        initializeDirectoryReferences();
        initializeNumArgsMap();
        
    }

    private void initializeDirectoryReferences () {
        for(String directory : myDirectorySet) {
            List<String> directoryReferences = Arrays.asList(myDirectoryListing.getString(directory).split("\\|"));
            for(String reference : directoryReferences) {
                myCommandToDirectoryMap.put(reference,directory);    
            }
        }
    }

    private void initializeNumArgsMap () {
        for(String command : myCommandSet) {
            myCommandToNumArgsMap.put(command, Integer.valueOf(myNumberArguments.getString(command).split("\\s+")[0]));
        }
    }

    private void initializeSyntaxMap () {
        mySyntaxMap = new HashMap<>();
        myReverseSyntaxMap = new LinkedHashMap<>();
        for (String command : mySyntaxReference.keySet()) {
            String reference  = mySyntaxReference.getString(command);
            mySyntaxMap.put(command, reference);
            myReverseSyntaxMap.put(reference,command);
        }
    }
    
    public void setLanguageAndReferences(String language) {
        myLanguage = language;
        setCommandReference(language);
    }

    /**
     * Sets the Reference Language for SLogo Commands
     * @param language to set to.
     */
    private void setCommandReference (String language) {
        myCommandReference = ResourceBundle.getBundle("resources.languages." + language, Locale.US);
        myCommandSet = myCommandReference.keySet();
        myDirectorySet = myDirectoryListing.keySet();

        for(String command : myCommandSet) {
            if(!mySyntaxReference.containsKey(command)) {
                List<String> commandReferences = Arrays.asList(myCommandReference.getString(command).split("\\|"));
                for(String reference : commandReferences) {
                    myReferenceToCommandMap.put(reference,command);
                }
            }
        }
    }

    //TODO
    public void addUserDefinedCommand (String command) {
        return;
    }

    public UserDefinedCommandsModel getUserDefinedCommands () {
        return  myDefinedCommands;
        
    }

    public UserDefinedVariablesModel getUserDefinedVariables () {
        return myDefinedVariables;
    }

    public Map<String,Integer> getCommandsToNumArgs () {
        return myCommandToNumArgsMap;
    }

    public Map<String,String> getReferencesToCommands () {
        return myReferenceToCommandMap;
    }

    public Map<String,String> getCommandsToDirectories () {
        return myCommandToDirectoryMap;
    }

    public Map<String,String> getReverseSyntaxes () {
        return myReverseSyntaxMap;
    }

    public Set<String> getSyntaxSet () {
        return mySyntaxMap.keySet();
    }

    public String getLogoLanguage () {
        return myLanguage;
    }

}