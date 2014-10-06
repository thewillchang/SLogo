package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;

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
	private UserDefinedMethodsWindowViewController myUserDefinedMethodsView;
	private UserDefinedVariablesWindowViewController myUserDefinedVariablesView;
	private HistoryWindowViewController myHistoryView;
	private CommandPromptViewController myCommandPromptView;
	private CommandStatusViewController myCommandStatusView;

	public CommandWindowViewController() {
		myPane = new BorderPane();
		myPane.setPrefSize(SIZE.width, SIZE.height);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {

	}

}
