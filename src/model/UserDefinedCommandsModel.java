package model;

import interpreter.expression.SLogoExpression;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Model for User Defined Methods
 * @author Tanaka Jimha and Will Chang
 */
public class UserDefinedCommandsModel implements Serializable {

    private Map<String,SLogoExpression> myDefinedCommands;
    private Map<String, List<String>> myDefinedCommandVariables;
    private Set<String> myCommands;

    public UserDefinedCommandsModel (){
        myDefinedCommands = new HashMap<>();
        myDefinedCommandVariables = new HashMap<>();
        myCommands = new HashSet<>();
    }
    /**
     * returns the current list of user defined methods
     * @return
     */
    public Map<String,SLogoExpression> getAllDefinedCommands() {
        return myDefinedCommands;
    }

    /**
     * returns the current list of user defined methods
     * @return
     */
    public SLogoExpression getCommand(String command) {
        return myDefinedCommands.get(command);
    }

    public List<String> getVariablesForCommand (String command) {
        return myDefinedCommandVariables.get(command);
    }
    
    public List<String> setVariablesForCommand (String command, List<String> variables) {
        return myDefinedCommandVariables.put(command, variables);
    }
    
    /**
     * adds an SLogo expression to the list of user defined methods
     * if method already exists with same name, then it is replaced
     * @param expression
     */
    public void putCommand (String command, SLogoExpression expression) {
        myCommands.add(command);
        myDefinedCommands.put(command, expression);
    }
    
    public boolean containsCommand (String command) {
        return myDefinedCommands.containsKey(command);
    }

}
