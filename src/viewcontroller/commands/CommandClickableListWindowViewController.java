package viewcontroller.commands;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Abstract 
 * @author Abhishek B
 *
 */
public abstract class CommandClickableListWindowViewController extends CommandWindowViewController {
	
	protected CommandWindowContainerViewController myCommandWindowContainer;
	protected VBox myListVerticalBox;

	public CommandClickableListWindowViewController() {
		super();
		myListVerticalBox = new VBox();
		myCommandWindowVerticalBox.getChildren().add(myListVerticalBox);
	}
	
	protected void addCommand(String commandLabelString) {
		Label commandLabel = new Label(commandLabelString);
		commandLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				myCommandWindowContainer.updateCommandWindow(commandLabelString);
			}
		});
		myListVerticalBox.getChildren().add(commandLabel);
	}
	
}
