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
 * Holds references to Syntax, Commands, and UserDefinedCommands
 * and Variables
 * 
 * @author Will Chang
 *
 */

public class CommandReferenceLibrary {
    
    public final String propertiesPath = "resources.languages.";
    public final String directory = "DirectoryListing";
    public final String numberArgs = "NumberArguments";
    public final String syntax = "Syntax";
    public final String splitSpace = "\\s+";
    public final String splitBar   = "\\|";
    
    private Set<String> myCommandSet;
    private Set<String> myDirectorySet;

    private Map<String, String> mySyntaxMap;
    private Map<String, String> myReverseSyntaxMap;
    private Map<String, String> myCommandToDirectoryMap;
    private Map<String, Integer> myCommandToNumArgsMap;
    private Map<String, String> myReferenceToCommandMap;

    private String myLanguage;
    private ResourceBundle myCommandReference; 
    private ResourceBundle myDirectoryListing;
    private ResourceBundle myNumberArguments;
    private ResourceBundle mySyntaxReference; 
    private UserDefinedCommandsModel myDefinedCommands;
    private UserDefinedVariablesModel myDefinedVariables;

    /**
     * Constructor
     * @param language of the References
     * @param commandsModel the commands model
     * @param variablesModel the variables model
     */
    public CommandReferenceLibrary (String language, 
                                    UserDefinedCommandsModel commandsModel,
                                    UserDefinedVariablesModel variablesModel) {
        myDirectoryListing = ResourceBundle.getBundle(propertiesPath + directory, Locale.US);
        myNumberArguments  = ResourceBundle.getBundle(propertiesPath + numberArgs, Locale.US);
        mySyntaxReference  = ResourceBundle.getBundle(propertiesPath + syntax, Locale.US);
        myDefinedCommands  = commandsModel;
        myDefinedVariables = variablesModel;
        myReferenceToCommandMap = new HashMap<>();
        myCommandToDirectoryMap = new HashMap<>();
        myCommandToNumArgsMap   = new HashMap<>();
        myDirectorySet = new HashSet<>();
        myCommandSet   = new HashSet<>();
        initializeSyntaxMap(); 
        setLanguageAndReferences(language);
        initializeDirectoryReferences();
        initializeNumArgsMap();
    }

    /**
     * Initialize the Directory References
     */
    private void initializeDirectoryReferences () {
        for (String directory : myDirectorySet) {
            List<String> directoryReferences = 
                    Arrays.asList(myDirectoryListing.getString(directory).split(splitBar));
            for (String reference : directoryReferences) {
                myCommandToDirectoryMap.put(reference, directory);    
            }
        }
    }

    /**
     * Initializes the NumArgsMap
     */
    private void initializeNumArgsMap () {
        for (String command : myCommandSet) {
            myCommandToNumArgsMap.put(command, Integer.valueOf(myNumberArguments.getString(command).split(splitSpace)[0]));
        }
    }

    /**
     * Initializes the SyntaxMap
     */
    private void initializeSyntaxMap () {
        mySyntaxMap = new HashMap<>();
        myReverseSyntaxMap = new LinkedHashMap<>();
        for (String command : mySyntaxReference.keySet()) {
            String reference  = mySyntaxReference.getString(command);
            mySyntaxMap.put(command, reference);
            myReverseSyntaxMap.put(reference, command);
        }
    }

    /**
     * Sets the language for the Command References
     * @param language
     */
    public void setLanguageAndReferences (String language) {
        myLanguage = language;
        setCommandReference(language);
    }

    /**
     * Sets the Reference Language for SLogo Commands
     * @param language to set to.
     */
    private void setCommandReference (String language) {
        myCommandReference = ResourceBundle.getBundle(propertiesPath + language, Locale.US);
        myCommandSet = myCommandReference.keySet();
        myDirectorySet = myDirectoryListing.keySet();

        for (String command : myCommandSet) {
            if (!mySyntaxReference.containsKey(command)) {
                List<String> commandReferences = 
                        Arrays.asList(myCommandReference.getString(command).split(splitBar));
                for (String reference : commandReferences) {
                    myReferenceToCommandMap.put(reference, command);
                }
            }
        }
    }

    /**
     * Getters for all References
     * @return
     */
    public UserDefinedCommandsModel getUserDefinedCommands () {
        return  myDefinedCommands;
    }

    public UserDefinedVariablesModel getUserDefinedVariables () {
        return myDefinedVariables;
    }

    public Map<String, Integer> getCommandsToNumArgs () {
        return myCommandToNumArgsMap;
    }

    public Map<String, String> getReferencesToCommands () {
        return myReferenceToCommandMap;
    }

    public Map<String, String> getCommandsToDirectories () {
        return myCommandToDirectoryMap;
    }

    public Map<String, String> getReverseSyntaxes () {
        return myReverseSyntaxMap;
    }

    public Set<String> getSyntaxSet () {
        return mySyntaxMap.keySet();
    }

    public String getLogoLanguage () {
        return myLanguage;
    }
}