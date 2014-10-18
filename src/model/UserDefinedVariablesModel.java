package model;

import interpreter.expression.SLogoExpression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Model for User Defined Variables
 * @author Tanaka Jimha
 *
 */
public class UserDefinedVariablesModel {
	
	private Map<String, Double> myUserVariables;
	
	public UserDefinedVariablesModel(){
		this.myUserVariables = new HashMap<>();
	}

	/**
	 * returns the current list of user defined variables
	 * @return
	 */
	public Map<String, Double> getVariables() {
		return this.myUserVariables;
	}
	
	/**
	 * adds an SLogo expression to the list of user defined variables
	 * if variable already exists with same name, then it is replaced
	 * @param expression
	 */
	public void putVariable(String variable, double value) {
		this.myUserVariables.put(variable, value);
	}
	
}
