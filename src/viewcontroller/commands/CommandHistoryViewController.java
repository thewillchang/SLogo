package viewcontroller.commands;

import java.util.*;

import viewcontroller.SLogoFont;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

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

	@Override
	public void update(Observable o, Object arg) {

	}
}
