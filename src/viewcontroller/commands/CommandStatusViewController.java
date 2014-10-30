package viewcontroller.commands;

import interpreter.result.SLogoResult;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import model.MainModel;
import viewcontroller.GUIReferenceLibrary;
import viewcontroller.MainModelObserver;
import viewcontroller.SLogoFont;


/**
 * Display status/return message of evaluated SLogo commands into this
 * ViewController
 *
 * @author Abhishek B
 *
 */
public class CommandStatusViewController extends CommandWindowViewController
implements MainModelObserver {
    private Label myStatusLabel;
    private static final String STATUS_KEY = "Status";
    private String myStatusTranslation;

    public CommandStatusViewController (int width, int height) {
        super(width, height);
        applyTranslations();
        setTitle(myStatusTranslation);
        setStatusLabel();
    }

    /**
     * Set the status Label object with formatting details
     */
    private void setStatusLabel () {
        myStatusLabel = new Label();
        myStatusLabel.setFont(new SLogoFont().createTextFont());
        myStatusLabel.setPadding(new Insets(0));
        myCommandWindowVerticalBox.getChildren().add(myStatusLabel);
    }

    /**
     * Display the return messages from the model
     * If the parsing did not function properly (i.e. invalid inputs), then
     * the error message will be displayed.
     */
    @Override
    public void update (MainModel model) {
        SLogoResult latestResult = model.getResult();
        if (latestResult != null && !latestResult.getHasError()) {
            updateCommandStatusText(Double.toString(latestResult.getValue()));
        }
        else {
            updateCommandStatusText(model.getErrorMessage());
        }
    }

    /**
     * Update the label for the text.
     *
     * @param commandResult
     */
    public void updateCommandStatusText (String commandResult) {
        myStatusLabel.setText(commandResult);
    }

    @Override
    public void applyTranslations () {
        myStatusTranslation = GUIReferenceLibrary.getStringTranslation(STATUS_KEY);
    }

    @Override
    public Node getNode () {
        return myPane;
    }
}
