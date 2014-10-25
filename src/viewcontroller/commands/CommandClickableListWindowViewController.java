package viewcontroller.commands;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
	protected ScrollPane myScrollPane;

	public CommandClickableListWindowViewController(int width, int height) {
		super(width, height);
		myListVerticalBox = new VBox();
		myCommandWindowVerticalBox.getChildren().add(myListVerticalBox);
		myScrollPane = new ScrollPane(myCommandWindowVerticalBox);
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myPane.setCenter(myScrollPane);
	}
	
	protected void addCommand(String commandLabelString) {
		Label commandLabel = new Label(commandLabelString);
		commandLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				myCommandWindowContainer.moveCommandTextToPromptWindow(commandLabelString);
			}
		});
		myListVerticalBox.getChildren().add(commandLabel);
		myScrollPane.setVvalue(myScrollPane.getVmax());
	}
	
}
