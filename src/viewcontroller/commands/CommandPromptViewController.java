package viewcontroller.commands;

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
import javafx.scene.paint.Color;
import model.MainModel;
import viewcontroller.SLogoFont;
import viewcontroller.ViewController;

/**
 * View Controller for the Text input where user types commands
 * 
 * @author Jonathan Tseng
 *
 */

public class CommandPromptViewController implements ViewController {

	private BorderPane myPane;
	private Label myTitleLabel;
	private MainModel myMainModel;
	private TextArea myCommandPromptTextArea;

	public CommandPromptViewController(MainModel mainModel) {
		myMainModel = mainModel;
		
		myPane = new BorderPane();
		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE,
				new CornerRadii(0), new Insets(0))));

		myTitleLabel = new Label("Prompt: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		myTitleLabel.setPadding(new Insets(0));

		setUpCommandPromptTextArea();
		
		myPane.setTop(myTitleLabel);
		myPane.setCenter(myCommandPromptTextArea);
	}
	
	private void setUpCommandPromptTextArea() {
		myCommandPromptTextArea = new TextArea();
		myCommandPromptTextArea.setPrefRowCount(4);
		myCommandPromptTextArea.setWrapText(true);
		myCommandPromptTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCode() == KeyCode.ENTER) {
					passCommandToModel(myCommandPromptTextArea.getText());
					myCommandPromptTextArea.clear();
					myCommandPromptTextArea.positionCaret(-1);
					//myCommandPromptTextArea.positionCaret(0);
				}
			}
		});
	}
	
	public void appendCommandToPromptTextArea(String commandFromPrelists) {
		myCommandPromptTextArea.appendText(commandFromPrelists);
	}

	private void passCommandToModel(String commandFromPromptTextArea) {
		myMainModel.interpretSLogoCommand(commandFromPromptTextArea);
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

}
