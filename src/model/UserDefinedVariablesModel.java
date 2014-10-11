package model;

import interpreter.expression.SLogoExpression;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Model for User Defined Variables
 * @author Tanaka Jimha
 *
 */
public class UserDefinedVariablesModel {
	
	private  Collection<SLogoExpression> uservariables;
	
	public UserDefinedVariablesModel(){
		this.uservariables = new ArrayList<SLogoExpression>();
	}

	/**
	 * returns the current list of user defined variables
	 * @return
	 */
	public Collection<SLogoExpression> getVariables() {
		return this.uservariables;
	}
	
	/**
	 * adds an SLogo expression to the list of user defined variables
	 * if variable already exists with same name, then it is replaced
	 * @param expression
	 */
	public void putVariable(SLogoExpression variable) {
		this.uservariables.add(variable);
	}
	
}
