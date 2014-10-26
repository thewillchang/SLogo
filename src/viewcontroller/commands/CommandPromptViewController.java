package viewcontroller.commands;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import viewcontroller.GUIReferenceLibrary;
import viewcontroller.ViewController;

/**
 * View Controller for the Text input where user types commands
 * 
 * @author Abhishek B
 *
 */

public class CommandPromptViewController extends CommandWindowViewController
		implements ViewController {

	private CommandWindowContainerViewController myParent;
	private HBox myCommandPromptHorizontalBox;
	private TextArea myCommandPromptTextArea;
	private Button mySubmitButton;
	private final String Prompt = "Prompt";
	private final String Submit = "Submit";
	private String myPromptTranslation;
	private String mySubmitTranslation;

	public CommandPromptViewController(int width, int height,
			CommandWindowContainerViewController parent) {
		super(width, height);
		myParent = parent;
		applyTranslations();
		setTitle(myPromptTranslation);
		setUpCommandPromptHorizontalBox();
		myCommandWindowVerticalBox.getChildren().add(
				myCommandPromptHorizontalBox);
	}

	public void setCommandPromptText(String text) {
		myCommandPromptTextArea.setText(text);
	}

	private void setUpCommandPromptHorizontalBox() {
		setUpCommandPrompt(SIZE.width * 9 / 10, SIZE.height * 9 / 10);
		setUpSubmitButton(SIZE.width * 9 / 10, SIZE.height * 9 / 10);
		myCommandPromptHorizontalBox = new HBox(10);
		myCommandPromptHorizontalBox.setPrefSize(SIZE.width * 9 / 10,
				SIZE.height * 9 / 10);
		myCommandPromptHorizontalBox.getChildren().addAll(
				myCommandPromptTextArea, mySubmitButton);
	}

	private void setUpCommandPrompt(int parentWidth, int parentHeight) {
		myCommandPromptTextArea = new TextArea();
		myCommandPromptTextArea.setPrefSize(parentWidth * 9 / 10,
				parentHeight * 8 / 10);
		myCommandPromptTextArea.setPrefColumnCount(10);
		myCommandPromptTextArea.setPrefRowCount(4);
		myCommandPromptTextArea.setWrapText(true);
	}

	private void setUpSubmitButton(int parentWidth, int parentHeight) {
		mySubmitButton = new Button(mySubmitTranslation);
		mySubmitButton.setPrefSize(parentWidth * 1 / 10, parentHeight * 1 / 5);
		mySubmitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				passCommandToModel(myCommandPromptTextArea.getText());
				myCommandPromptTextArea.clear();
			}
		});
	}

	public void appendCommandToPromptTextArea(String commandFromLists) {
		myCommandPromptTextArea.setText(commandFromLists);
	}

	private void passCommandToModel(String commandFromPromptTextArea) {
		if (commandFromPromptTextArea.trim().length() > 0)
			myParent.passSLogoCommand(commandFromPromptTextArea);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void applyTranslations() {
		myPromptTranslation = GUIReferenceLibrary.getStringTranslation(Prompt);
		mySubmitTranslation = GUIReferenceLibrary.getStringTranslation(Submit);
	}

}
