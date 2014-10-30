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
 * View Controller for the TextArea where the user types
 * the commands as strings to be sent to the back end.
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
    private final String PROMPT_KEY = "Prompt";
    private final String SUBMIT_KEY = "Submit";
    private String myPromptTranslation;
    private String mySubmitTranslation;

    public CommandPromptViewController (int width, int height,
                                        CommandWindowContainerViewController parent) {
        super(width, height);
        myParent = parent;
        applyTranslations();
        setTitle(myPromptTranslation);
        setUpCommandPromptHorizontalBox();
        myCommandWindowVerticalBox.getChildren().add(
                                                     myCommandPromptHorizontalBox);
    }

    /**
     * Set the command prompt text area with the input text string.
     *
     * @param commandText
     */
    public void setCommandPromptText (String commandText) {
        myCommandPromptTextArea.setText(commandText);
    }

    /**
     * Initialize the HBox containing the TextArea and Button
     */
    private void setUpCommandPromptHorizontalBox () {
        setUpCommandPrompt(SIZE.width * 9 / 10, SIZE.height * 9 / 10);
        setUpSubmitButton(SIZE.width * 9 / 10, SIZE.height * 9 / 10);
        myCommandPromptHorizontalBox = new HBox(10);
        myCommandPromptHorizontalBox.setPrefSize(SIZE.width * 9 / 10,
                                                 SIZE.height * 9 / 10);
        myCommandPromptHorizontalBox.getChildren().addAll(
                                                          myCommandPromptTextArea, mySubmitButton);
    }

    /**
     * Initialize the TextArea for inputting command text
     *
     * @param parentWidth
     * @param parentHeight
     */
    private void setUpCommandPrompt (int parentWidth, int parentHeight) {
        myCommandPromptTextArea = new TextArea();
        myCommandPromptTextArea.setPrefSize(parentWidth * 9 / 10,
                                            parentHeight * 8 / 10);
        myCommandPromptTextArea.setPrefColumnCount(10);
        myCommandPromptTextArea.setPrefRowCount(4);
        myCommandPromptTextArea.setWrapText(true);
    }

    /**
     * Initialize button, which will send all content from TextArea
     * and clear the TextArea upon execution.
     *
     * @param parentWidth
     * @param parentHeight
     */
    private void setUpSubmitButton (int parentWidth, int parentHeight) {
        mySubmitButton = new Button(mySubmitTranslation);
        mySubmitButton.setPrefSize(parentWidth * 1 / 10, parentHeight * 1 / 5);
        mySubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                passCommandToModel(myCommandPromptTextArea.getText());
                myCommandPromptTextArea.clear();
            }
        });
    }

    /**
     * Called by submit button
     *
     * @param commandFromPromptTextArea
     */
    private void passCommandToModel (String commandFromPromptTextArea) {
        if (commandFromPromptTextArea.trim().length() > 0) {
            myParent.passSLogoCommand(commandFromPromptTextArea);
        }
    }

    @Override
    public Node getNode () {
        return myPane;
    }

    @Override
    public void applyTranslations () {
        myPromptTranslation = GUIReferenceLibrary.getStringTranslation(PROMPT_KEY);
        mySubmitTranslation = GUIReferenceLibrary.getStringTranslation(SUBMIT_KEY);
    }
}
