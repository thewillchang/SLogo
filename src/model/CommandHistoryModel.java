package model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Model for History of commands user has typed
 * @author Tanaka Jimha
 *
 */
public class CommandHistoryModel {
	
	private Collection<String> commandHistory;
	
	public CommandHistoryModel(){
		 this.commandHistory = new ArrayList<String>();
	}
	/**
	 * adds a command to the command history
	 * @param command
	 */
	public void addCommand(String command) {
		this.commandHistory.add(command);
	}
	
	/**
	 * returns the full command history--used to update the viewcontroller
	 * @return
	 */
	public Collection<String> getHistory() {
		return commandHistory;
	}
	
}
