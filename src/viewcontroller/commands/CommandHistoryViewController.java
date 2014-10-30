package viewcontroller.commands;

import java.util.List;
import javafx.scene.Node;
import model.CommandHistoryModel;
import model.MainModel;
import viewcontroller.GUIReferenceLibrary;
import viewcontroller.MainModelObserver;


/**
 * View controller for window of history of commands
 * A type of extension of ClickableListWindowViewController
 *
 * @author Abhishek B
 *
 */
public class CommandHistoryViewController extends CommandClickableListWindowViewController
implements MainModelObserver {

    private final String HISTORY_KEY = "History";
    private String myHistoryTranslation;

    public CommandHistoryViewController (int width,
                                         int height,
                                         CommandWindowContainerViewController commandWindowContainer) {
        super(width, height);
        myCommandWindowContainer = commandWindowContainer;
        applyTranslations();
        setTitle(myHistoryTranslation);
    }

    @Override
    public Node getNode () {
        return myPane;
    }

    /**
     * Updates by repopulating the command history list with strings
     */
    @Override
    public void update (MainModel model) {
        myListVerticalBox.getChildren().clear();
        CommandHistoryModel historyModel = model.getCommandHistory();
        List<String> commandHistory = historyModel.getHistory();
        for (String command : commandHistory) {
            addCommand(command);
        }
    }

    @Override
    public void applyTranslations () {
        myHistoryTranslation = GUIReferenceLibrary.getStringTranslation(HISTORY_KEY);
    }
}
