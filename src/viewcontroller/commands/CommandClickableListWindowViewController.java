package viewcontroller.commands;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
/**
 * Abstract class for clickable lists - particularly, the command history and
 * user defined methods lists.
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
	/**
	 * Add a command as a Label, and upon click, this will be populated in the 
	 * command prompt window via the parent container.
	 * @param commandLabelString - Label text
	 */
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