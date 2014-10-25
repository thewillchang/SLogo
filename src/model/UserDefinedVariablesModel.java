package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Model for User Defined Variables
 * @author Tanaka Jimha and Will Chang
 *
 */
public class UserDefinedVariablesModel implements Serializable {
	
	private Map<String, Double> myDefinedVariables;
	private Set<String> myVariables;
	
	public UserDefinedVariablesModel(){
		myDefinedVariables = new HashMap<>();
		myVariables = new HashSet<>();
	}

	/**
	 * returns the current list of user defined variables
	 * @return
	 */
	public Map<String, Double> getAllVariables() {
		return myDefinedVariables;
	}
	
	public Double getVariable(String variable) {
	    return myDefinedVariables.get(variable);
	}
	//TODO Add exception and check that the string being added is actually a variable regex.
	/**
	 * adds an SLogo expression to the list of user defined variables
	 * if variable already exists with same name, then it is replaced
	 * @param expression
	 */
	public void putVariable (String variable, double value) {
		myDefinedVariables.put(variable, value);
	}

    public boolean containsVariable (String myValue) {
        return myDefinedVariables.containsKey(myValue);      
    }

    public void remove (String repCount) {
        myDefinedVariables.remove(repCount);
        myVariables.remove(repCount);
        
    }
	
}
