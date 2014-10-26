package viewcontroller.commands;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Abstract
 * 
 * @author Abhishek B
 *
 */
public abstract class CommandClickableListWindowViewController extends
		CommandListWindowViewController {

	protected CommandWindowContainerViewController myCommandWindowContainer;

	public CommandClickableListWindowViewController(int width, int height) {
		super(width, height);
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
		updateScroller();
	}
}
