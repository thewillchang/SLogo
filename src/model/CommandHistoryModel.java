package model;

import interpreter.expression.SLogoExpression;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Model for History of commands user has typed
 * @author Tanaka Jimha
 *
 */
public class CommandHistoryModel {
	
	private Collection<SLogoExpression> commandHistory;
	
	public CommandHistoryModel(){
		 this.commandHistory = new ArrayList<SLogoExpression>();
	}
	/**
	 * adds a command to the command history
	 * @param command
	 */
	public void addCommand(SLogoExpression command) {
		this.commandHistory.add(command);
	}
	
	/**
	 * returns the full command history--used to update the viewcontroller
	 * @return
	 */
	public Collection<SLogoExpression> getHistory() {
		return commandHistory;
	}
	
}
