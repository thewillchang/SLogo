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
	protected List<Label> myCommands;

	public CommandClickableListWindowViewController() {
		super();
		myListVerticalBox = new VBox();
		myCommands = new ArrayList<Label>();
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
		myCommands.add(commandLabel);
	}
	
}
