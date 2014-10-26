package viewcontroller.commands;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Abstract
 * 
 * @author Abhishek B
 *
 */
public abstract class CommandClickableListWindowViewController extends
		CommandWindowViewController {

	protected CommandWindowContainerViewController myCommandWindowContainer;
	protected VBox myListVerticalBox;
	
	public CommandClickableListWindowViewController(int width, int height) {
		super(width, height);
		myListVerticalBox = new VBox();
		myCommandWindowVerticalBox.getChildren().addAll(myListVerticalBox);
	}

	protected void addCommand(String commandLabelString) {
		Label commandLabel = new Label(commandLabelString);
		commandLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				myCommandWindowContainer
						.moveCommandTextToPromptWindow(commandLabelString);
			}
		});
		myListVerticalBox.getChildren().add(commandLabel);
	}

}
