package viewcontroller.commands;

import javafx.scene.Node;
import javafx.scene.control.Label;
import viewcontroller.SLogoFont;

/**
 * view controller for window for user defined methods
 * 
 * @author Abhishek B
 *
 */
public class UserDefinedMethodsViewController extends CommandClickableListWindowViewController {

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

	@Override
	public Node getNode() {
		return myPane;
	}

}
