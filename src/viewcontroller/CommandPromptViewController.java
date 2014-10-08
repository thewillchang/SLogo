package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
	private TextArea myCommandPromptTextArea;
	private CommandWindowViewController myCommandWindow;

	public CommandPromptViewController(CommandWindowViewController commandWindow) {
		myCommandWindow = commandWindow;
		
		myPane = new BorderPane();
		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE,
				new CornerRadii(0), new Insets(0))));

		myTitleLabel = new Label("Prompt: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		myTitleLabel.setPadding(new Insets(0));

		myCommandPromptTextArea = new TextArea();
		myCommandPromptTextArea.setPrefRowCount(4);
		myCommandPromptTextArea.setWrapText(true);
		myCommandPromptTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCode() == KeyCode.ENTER) {
					passCommandToStatus(myCommandPromptTextArea.getText());
					myCommandPromptTextArea.clear();
				}
			}
		});

		myWindowVerticalBox = new VBox();
		myWindowVerticalBox.getChildren().addAll(myTitleLabel,
				myCommandPromptTextArea);

		myPane.setCenter(myWindowVerticalBox);
	}
	
	public void appendCommandToPromptTextArea(String commandFromPrelists) {
		myCommandPromptTextArea.appendText(commandFromPrelists);
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
