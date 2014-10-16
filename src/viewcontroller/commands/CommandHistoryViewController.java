package viewcontroller.commands;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import viewcontroller.SLogoFont;

/**
 * View controller for window of history of commands
 * 
 * @author Abhishek B
 *
 */

public class CommandHistoryViewController extends CommandClickableListWindowViewController {

	private CommandWindowContainerViewController myCommandWindowContainer;

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

	private void addCommand(String commandLabelString) {
		Label commandLabel = new Label(commandLabelString);
		commandLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				myCommandWindowContainer.updateCommandWindow(commandLabelString);
			}

		});
		myCommands.add(commandLabel);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

}
