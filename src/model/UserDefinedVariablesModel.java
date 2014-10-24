package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Model for User Defined Variables
 * @author Tanaka Jimha and Will Chang
 *
 */
public class UserDefinedVariablesModel {
	
	private Map<String, Double> myUserVariables;
	
	public UserDefinedVariablesModel(){
		myUserVariables = new HashMap<>();
	}

	/**
	 * returns the current list of user defined variables
	 * @return
	 */
	public Map<String, Double> getVariables() {
		return myUserVariables;
	}
	
	/**
	 * adds an SLogo expression to the list of user defined variables
	 * if variable already exists with same name, then it is replaced
	 * @param expression
	 */
	public void putVariable(String variable, double value) {
		myUserVariables.put(variable, value);
	}
	
}
