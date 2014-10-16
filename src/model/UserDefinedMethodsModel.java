package model;

import interpreter.expression.SLogoExpression;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Model for User Defined Methods
 * @author Tanaka Jimha
 *
 */
public class UserDefinedMethodsModel {
	
	private Collection<SLogoExpression> userMethods;
	
	public UserDefinedMethodsModel(){
		this.userMethods = new ArrayList<SLogoExpression>();
	}
	/**
	 * returns the current list of user defined methods
	 * @return
	 */
	public Collection<SLogoExpression> getMethods() {
		return userMethods;
	}
	
	/**
	 * adds an SLogo expression to the list of user defined methods
	 * if method already exists with same name, then it is replaced
	 * @param expression
	 */
	public void putMethod(SLogoExpression method) {
		this.userMethods.add(method);
	}
	
}
