package viewcontroller.commands;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;

public abstract class CommandListWindowViewController extends CommandWindowViewController {

	protected ScrollPane myScrollPane;
	protected VBox myListVerticalBox;
	
	public CommandListWindowViewController(int width, int height) {
		super(width, height);
		myListVerticalBox = new VBox();
		myCommandWindowVerticalBox.getChildren().add(myListVerticalBox);
		myScrollPane = new ScrollPane(myCommandWindowVerticalBox);
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myPane.setCenter(myScrollPane);
	}

	protected void updateScroller() {
		myScrollPane.setVvalue(myScrollPane.getVmax());
	}
}
