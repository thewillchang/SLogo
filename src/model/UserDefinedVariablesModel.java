package model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Model for User Defined Variables
 * @author Tanaka Jimha
 *
 */
public class UserDefinedVariablesModel {
	
	private  Collection<String> uservariables;
	
	public UserDefinedVariablesModel(){
		this.uservariables = new ArrayList<String>();
	}

	/**
	 * returns the current list of user defined variables
	 * @return
	 */
	public Collection<String> getVariables() {
		return this.uservariables;
	}
	
	/**
	 * adds an SLogo expression to the list of user defined variables
	 * if variable already exists with same name, then it is replaced
	 * @param expression
	 */
	public void putVariable(String variable) {
		this.uservariables.add(variable);
	}
	
}
