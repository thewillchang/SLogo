package model;

import interpreter.expression.SLogoExpression;

import java.util.Collection;
import java.util.Observable;

/**
 * Model for User Defined Methods
 * @author Jonathan Tseng
 *
 */
public class UserDefinedMethodsModel extends Observable {

	/**
	 * returns the current list of user defined methods
	 * @return
	 */
	public Collection<SLogoExpression> getMethods() {
		return null;
	}
	
	/**
	 * adds an SLogo expression to the list of user defined methods
	 * if method already exists with same name, then it is replaced
	 * @param expression
	 */
	public void putMethod(SLogoExpression method) {
		
	}
	
}
