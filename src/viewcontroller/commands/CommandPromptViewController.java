package viewcontroller.commands;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import model.MainModel;
import viewcontroller.SLogoFont;
import viewcontroller.ViewController;

/**
 * View Controller for the Text input where user types commands
 * 
 * @author Abhishek B
 *
 */

public class CommandPromptViewController implements ViewController {

	private BorderPane myPane;
	private Label myTitleLabel;
	private MainModel myMainModel;
	private TextArea myCommandPromptTextArea;
	private Button mySubmitButton;
	private HBox myCommandPromptHorizontalBox;

	public CommandPromptViewController(MainModel mainModel) {
		myMainModel = mainModel;

		myPane = new BorderPane();
		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE,
				new CornerRadii(0), new Insets(0))));

		myTitleLabel = new Label("Prompt: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		myTitleLabel.setPadding(new Insets(0));

		setUpCommandPrompt();
		myCommandPromptHorizontalBox = new HBox(10);
		HBox.setHgrow(myCommandPromptTextArea, Priority.ALWAYS);
		HBox.setHgrow(mySubmitButton, Priority.ALWAYS);
		myCommandPromptHorizontalBox.getChildren().addAll(
				myCommandPromptTextArea, mySubmitButton);

		myPane.setTop(myTitleLabel);
		myPane.setCenter(myCommandPromptHorizontalBox);
	}

	private void setUpCommandPrompt() {
		myCommandPromptTextArea = new TextArea();
		myCommandPromptTextArea.setPrefColumnCount(10);
		myCommandPromptTextArea.setPrefRowCount(4);
		myCommandPromptTextArea.setWrapText(true);

		mySubmitButton = new Button(">");
		mySubmitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				passCommandToModel(myCommandPromptTextArea.getText());
				myCommandPromptTextArea.clear();
			}
		});
	}

	public void appendCommandToPromptTextArea(String commandFromLists) {
		myCommandPromptTextArea.appendText(commandFromLists);
	}

	private void passCommandToModel(String commandFromPromptTextArea) {
		myMainModel.interpretSLogoCommand(commandFromPromptTextArea);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

}
