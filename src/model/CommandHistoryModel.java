package model;

import interpreter.expression.SLogoExpression;

import java.util.Collection;
import java.util.Observable;

/**
 * Model for History of commands user has typed
 * @author Jonathan Tseng
 *
 */
public class CommandHistoryModel extends Observable {

	/**
	 * adds a command to the command history
	 * @param command
	 */
	public void addCommand(SLogoExpression command) {
		
	}
	
	/**
	 * removes a command from the command history
	 * @param command
	 */
	public void removeCommand(SLogoExpression command) {
		
	}
	
	/**
	 * returns the full command history--used to update the viewcontroller
	 * @return
	 */
	public Collection<SLogoExpression> getHistory() {
		return null;
	}
	
}
