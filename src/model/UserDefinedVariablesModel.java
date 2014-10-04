package model;

import interpreter.expression.SLogoExpression;

import java.util.Collection;

/**
 * Model for User Defined Variables
 * @author Jonathan Tseng
 *
 */
public class UserDefinedVariablesModel {

	/**
	 * returns the current list of user defined variables
	 * @return
	 */
	public Collection<SLogoExpression> getVariables() {
		return null;
	}
	
	/**
	 * adds an SLogo expression to the list of user defined variables
	 * if variable already exists with same name, then it is replaced
	 * @param expression
	 */
	public void putVariable(SLogoExpression variable) {
		
	}
	
}
