package model;

import interpreter.expression.SLogoExpression;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model for User Defined Methods
 * @author Tanaka Jimha and Will Chang
 * TODO UPDATE THIS AND THE VIEW THAT TAKES INFO FROM THIS.......
 */
public class UserDefinedCommandsModel {
	
	private List<String> myDefinedCommands;
	
	public UserDefinedCommandsModel (){
		myDefinedCommands = new ArrayList<>();
	}
	/**
	 * returns the current list of user defined methods
	 * @return
	 */
	public List<String> getDefinedCommands() {
		return myDefinedCommands;
	}
	
	/**
	 * adds an SLogo expression to the list of user defined methods
	 * if method already exists with same name, then it is replaced
	 * @param expression
	 */
	public void put (String command, SLogoExpression expression) {
	   // myDefinedCommands.put(command, expression);
	}
	
}
