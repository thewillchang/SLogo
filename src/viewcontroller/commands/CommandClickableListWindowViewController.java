package viewcontroller.commands;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public abstract class CommandClickableListWindowViewController extends CommandWindowViewController {
	
	protected VBox myListVerticalBox;
	protected List<Label> myCommands;

	public CommandClickableListWindowViewController() {
		super();
		myListVerticalBox = new VBox();
		myCommands = new ArrayList<Label>();
		myCommandWindowVerticalBox.getChildren().add(myListVerticalBox);
	}
	
}
