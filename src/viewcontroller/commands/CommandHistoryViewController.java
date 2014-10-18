package viewcontroller.commands;

import javafx.scene.Node;
import javafx.scene.control.Label;
import viewcontroller.SLogoFont;

/**
 * View controller for window of history of commands
 * 
 * @author Abhishek B
 *
 */

public class CommandHistoryViewController extends CommandClickableListWindowViewController {

	public CommandHistoryViewController(
			CommandWindowContainerViewController commandWindow) {
		super();
		myCommandWindowContainer = commandWindow;
		
		myTitleLabel.setText("Command History Window: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());

		placeCommandList();
	}

	private void placeCommandList() {
		addCommand("fd 50");

		for (Label command : myCommands) {
			myListVerticalBox.getChildren().add(command);
		}
	}

	@Override
	public Node getNode() {
		return myPane;
	}

}
