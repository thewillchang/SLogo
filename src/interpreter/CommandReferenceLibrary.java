package interpreter;

import interpreter.expression.SLogoExpression;
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

	// private Map<Pattern, String> patternsToCommandMap;
	private Map<String, String> myReferenceToCommandMap;

	private final String COMMENT = "\\#";
	private final String CONSTANT = "-?[0-9]+\\.?[0-9]*";
	private final String VARIABLE = ":[a-zA-z]+";
	private final String COMMAND = "[a-zA-z_] + (\\?)?";
	private final String LIST_START = "\\[";
	private final String LIST_END = "\\]";
	private final String GROUP_START = "\\(";
	private final String GROUP_END = "\\)";

	// Deprecated
	// private Map<String, List<String>> commandMap;
	private Set<String> myCommandSet;
	private Set<String> myDirectorySet;

	private Map<String, String> mySyntaxMap;
	private Map<String, String> myReverseSyntaxMap;
	private Map<String, String> myCommandToDirectoryMap;
	private Map<String, Integer> myCommandToNumArgsMap;

	private Map<String, SLogoExpression> myUserDefinedCommandsMap;
	private Map<String, SLogoExpression> myUserDefinedVariablesMap;

	private String myLanguage;

	private ResourceBundle myCommandReference;
	private ResourceBundle myDirectoryListing;
	private ResourceBundle myNumberArguments;

	// TODO Refactor or delete... the functionality is the same as hashmap.....
	private UserDefinedCommandsModel myDefinedMethods;
	private UserDefinedVariablesModel myDefinedVariables;

	// private final String DEFAULT_LANGUAGE = "English";

	public CommandReferenceLibrary() {
		this("English");
	}

	public CommandReferenceLibrary(String language) {

		myLanguage = language;

		myCommandSet = new HashSet<>();
		// commandMap = new HashMap<>();
		myReferenceToCommandMap = new HashMap<>();

		myDirectorySet = new HashSet<>();
		myCommandToDirectoryMap = new HashMap<>();
		myCommandToNumArgsMap = new HashMap<>();

		myDefinedMethods = new UserDefinedCommandsModel();
		myDefinedVariables = new UserDefinedVariablesModel();

		myUserDefinedCommandsMap = new HashMap<>();
		myUserDefinedVariablesMap = new HashMap<>();

		// TODO refactor..
		initializeSyntaxMap();

		setCommandReference(language);
		initializeNumArgsMap();
	}

	private void initializeNumArgsMap() {
		for (String command : myCommandSet) {
			myCommandToNumArgsMap.put(
					command,
					Integer.valueOf(myNumberArguments.getString(command).split(
							"\\s+")[0]));
		}
	}

	public void addUserDefinedCommand(String command) {
		return;
	}

	public Map<String, SLogoExpression> getUserDefinedCommands() {
		return myUserDefinedCommandsMap;
	}

	public Map<String, SLogoExpression> getUserDefinedVariables() {
		return myUserDefinedVariablesMap;
	}

	public Map<String, Integer> getCommandsToNumArgs() {
		return myCommandToNumArgsMap;
	}

	public Map<String, String> getReferencesToCommands() {
		return myReferenceToCommandMap;
	}

	public Map<String, String> getCommandsToDirectories() {
		return myCommandToDirectoryMap;
	}

	public Map<String, String> getReverseSyntaxes() {
		return myReverseSyntaxMap;
	}

	public Set<String> getSyntaxSet() {
		return mySyntaxMap.keySet();
	}

	public String getLogoLanguage() {
		return myLanguage;
	}

	// TODO temp fix, will refactor
	private void initializeSyntaxMap() {
		mySyntaxMap = new HashMap<>();
		mySyntaxMap.put("Comment", COMMENT);
		mySyntaxMap.put("Constant", CONSTANT);
		mySyntaxMap.put("Variable", VARIABLE);
		mySyntaxMap.put("Command", COMMAND);
		mySyntaxMap.put("ListStart", LIST_START);
		mySyntaxMap.put("ListEnd", LIST_END);
		mySyntaxMap.put("GroupStart", GROUP_START);
		mySyntaxMap.put("GroupEnd", GROUP_END);

		myReverseSyntaxMap = new LinkedHashMap<>();
		myReverseSyntaxMap.put(COMMENT, "Comment");
		myReverseSyntaxMap.put(CONSTANT, "Constant");
		myReverseSyntaxMap.put(VARIABLE, "Variable");
		myReverseSyntaxMap.put(LIST_START, "ListStart");
		myReverseSyntaxMap.put(LIST_END, "ListEnd");
		myReverseSyntaxMap.put(GROUP_START, "GroupStart");
		myReverseSyntaxMap.put(GROUP_END, "GroupEnd");
		myReverseSyntaxMap.put(COMMAND, "Command");
	}

	/**
	 * Sets the Reference Language for SLogo Commands
	 * 
	 * @param language
	 *            to set to.
	 */
	private void setCommandReference(String language) {
		myCommandReference = ResourceBundle.getBundle("resources.languages."
				+ language, Locale.US);
		myDirectoryListing = ResourceBundle.getBundle(
				"resources.languages.DirectoryListing", Locale.US);
		myNumberArguments = ResourceBundle.getBundle(
				"resources.languages.NumberArguments", Locale.US);

		myCommandSet = myCommandReference.keySet();
		myDirectorySet = myDirectoryListing.keySet();
		Set<String> syntaxSet = mySyntaxMap.keySet();

		// SpecialRegex...
		String specialRegex = "[^A-Za-z0-9]";
		for (String command : myCommandSet) {
			// Tempory fix for special characters from syntax set
			if (!syntaxSet.contains(command)) {
				List<String> commandReferences = Arrays
						.asList(myCommandReference.getString(command)
								.split(","));
				// for CommandMap
				// commandMap.put(command, commandReferences);

				for (String reference : commandReferences) {
					if (reference.matches(specialRegex)) {
						reference = "\\" + reference;
					}
					myReferenceToCommandMap.put(reference, command);
				}
			}

		}

		// Setup for normal commands
		for (String directory : myDirectorySet) {
			List<String> directoryReferences = Arrays.asList(myDirectoryListing
					.getString(directory).split(","));
			for (String reference : directoryReferences) {
				myCommandToDirectoryMap.put(reference, directory);
			}
		}
	}

}
