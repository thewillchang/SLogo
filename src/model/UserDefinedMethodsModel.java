package model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Model for User Defined Methods
 * @author Tanaka Jimha
 *
 */
public class UserDefinedMethodsModel {
	
	private Collection<String> userMethods;
	
	public UserDefinedMethodsModel(){
		this.userMethods = new ArrayList<String>();
	}
	/**
	 * returns the current list of user defined methods
	 * @return
	 */
	public Collection<String> getMethods() {
		return userMethods;
	}
	
	/**
	 * adds an SLogo expression to the list of user defined methods
	 * if method already exists with same name, then it is replaced
	 * @param expression
	 */
	public void putMethod(String method) {
		this.userMethods.add(method);
	}
	
}
