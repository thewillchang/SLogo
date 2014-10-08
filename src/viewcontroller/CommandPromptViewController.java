package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * View Controller for the Text input where user types commands
 * 
 * @author Jonathan Tseng
 *
 */

public class CommandPromptViewController implements Observer, ViewController {

	private BorderPane myPane;
	private Label myTitleLabel;
	private VBox myWindowVerticalBox;
	private TextArea myCommandTextArea;
	private CommandWindowViewController myCommandWindow;

	public CommandPromptViewController(CommandWindowViewController commandWindow) {
		myCommandWindow = commandWindow;
		
		myPane = new BorderPane();
		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE,
				new CornerRadii(0), new Insets(0))));

		myTitleLabel = new Label("Prompt: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		myTitleLabel.setPadding(new Insets(0));

		TextArea myCommandTextArea = new TextArea();
		myCommandTextArea.setPrefRowCount(4);
		myCommandTextArea.setWrapText(true);
		myCommandTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCode() == KeyCode.ENTER) {
					passCommandToStatus(myCommandTextArea.getText());
					myCommandTextArea.clear();
				}
			}
		});

		myWindowVerticalBox = new VBox();
		myWindowVerticalBox.getChildren().addAll(myTitleLabel,
				myCommandTextArea);

		myPane.setCenter(myWindowVerticalBox);
	}

	private void passCommandToStatus(String commandFromPromptTextArea) {
		myCommandWindow.updateStatusWindow(commandFromPromptTextArea);
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {

	}

}
