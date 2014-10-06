package viewcontroller;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
	private UserDefinedMethodsWindowViewController myUserDefinedMethodsView;
	private UserDefinedVariablesWindowViewController myUserDefinedVariablesView;
	private HistoryWindowViewController myHistoryView;
	private CommandPromptViewController myCommandPromptView;
	private CommandStatusViewController myCommandStatusView;

	public CommandWindowViewController() {
		myPane = new BorderPane();
		
		myPane.setPrefSize(SIZE.width, SIZE.height);
		commandWindowVerticalBox = new VBox();
		
		HBox userDefinedHorizontalBox = placeUserDefinedBoxes();
		myHistoryView = new HistoryWindowViewController();
		myCommandPromptView = new CommandPromptViewController();
		myCommandStatusView = new CommandStatusViewController();
		
//		commandWindowVerticalBox.
//		commandWindowVerticalBox.addAll(/*placeUserDefinedBoxes(), */myHistoryView, myCommandPromptView, myCommandStatusView);
	}
	
	private HBox placeUserDefinedBoxes() {
		HBox userDefinedHorizontalBox = new HBox();
		myUserDefinedMethodsView = new UserDefinedMethodsWindowViewController();
		myUserDefinedVariablesView = new UserDefinedVariablesWindowViewController();
		
//		userDefinedHorizontalBox.addAll(myUserDefinedMethodsView, myUserDefinedVariablesView);
//		return HBox;
		return null;
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
