package viewcontroller.commands;

import java.util.Observable;
import viewcontroller.SLogoFont;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * view controller for window for user defined methods
 * 
 * @author Abhishek B
 *
 */
public class UserDefinedMethodsViewController extends CommandClickableListWindowViewController {

	private CommandWindowContainerViewController myCommandWindowContainer;

	public UserDefinedMethodsViewController(
			CommandWindowContainerViewController commandWindowContainer) {
		super();
		myCommandWindowContainer = commandWindowContainer;
		myTitleLabel.setText("User Defined Methods: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		placeCommandList();
	}

	private void placeCommandList() {
		addCommand("sit 50");
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
