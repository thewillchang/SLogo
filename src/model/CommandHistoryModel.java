package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Model for History of commands user has typed
 *
 * @author Tanaka Jimha
 *
 */
public class CommandHistoryModel implements Serializable {

    private List<String> commandHistory;

    public CommandHistoryModel () {
        commandHistory = new ArrayList<String>();
    }

    /**
     * adds a command to the command history
     *
     * @param command
     */
    public void addCommand (String command) {
        commandHistory.add(command);
    }

    /**
     * returns the full command history--used to update the viewcontroller
     *
     * @return
     */
    public List<String> getHistory () {
        return commandHistory;
    }

}
