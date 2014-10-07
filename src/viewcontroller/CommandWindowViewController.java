package viewcontroller;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import application.Main;

/**
 * ViewController for Command Windows (where command prompt, command status,
 * history, and user defined windows are located)
 * 
 * @author Abhishek B
 *
 */

public class CommandWindowViewController implements Observer, ViewController {

	public static final Dimension SIZE = new Dimension(
			Main.SIZE.width / 2 * 9 / 10, Main.SIZE.height * 9 / 10);

	private BorderPane myPane;
	private VBox commandWindowVerticalBox;
	private UserDefinedMethodsViewController myUserDefinedMethodsView;
	private UserDefinedVariablesViewController myUserDefinedVariablesView;
	private CommandHistoryViewController myCommandHistoryView;
	private CommandPromptViewController myCommandPromptView;
	private CommandStatusViewController myCommandStatusView;

	public CommandWindowViewController() {
		myPane = new BorderPane();
		myPane.setPrefSize(SIZE.width, SIZE.height);

		commandWindowVerticalBox = new VBox();
		
		HBox userDefinedHorizontalBox = placeUserDefinedBoxes();
		myCommandHistoryView = new CommandHistoryViewController();
		myCommandPromptView = new CommandPromptViewController();
		myCommandStatusView = new CommandStatusViewController();
		
		VBox.setVgrow(userDefinedHorizontalBox, Priority.ALWAYS);
		VBox.setVgrow(myCommandHistoryView.getNode(), Priority.ALWAYS);
		VBox.setVgrow(myCommandPromptView.getNode(), Priority.ALWAYS);
		VBox.setVgrow(myCommandStatusView.getNode(), Priority.ALWAYS);
		commandWindowVerticalBox.getChildren().addAll(userDefinedHorizontalBox, myCommandHistoryView.getNode(), 
				myCommandPromptView.getNode(), myCommandStatusView.getNode());
		myPane.setCenter(commandWindowVerticalBox);
	}
	
	private HBox placeUserDefinedBoxes() {
		HBox userDefinedHorizontalBox = new HBox();
		myUserDefinedMethodsView = new UserDefinedMethodsViewController();
		myUserDefinedVariablesView = new UserDefinedVariablesViewController();
		HBox.setHgrow(myUserDefinedMethodsView.getNode(), Priority.ALWAYS);
		HBox.setHgrow(myUserDefinedVariablesView.getNode(), Priority.ALWAYS);
		userDefinedHorizontalBox.getChildren().addAll(myUserDefinedMethodsView.getNode(), myUserDefinedVariablesView.getNode());
		return userDefinedHorizontalBox;
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
