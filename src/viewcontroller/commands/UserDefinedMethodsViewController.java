package viewcontroller.commands;

import java.util.Set;
import javafx.scene.Node;
import model.MainModel;
import model.UserDefinedCommandsModel;
import viewcontroller.GUIReferenceLibrary;
import viewcontroller.MainModelObserver;


/**
 * ViewController contained User-Defined Method string names
 *
 * @author Abhishek B
 *
 */
public class UserDefinedMethodsViewController extends
CommandClickableListWindowViewController implements MainModelObserver {
    private final static String User_KEY = "UserMethods";
    private String myUserTranslation;

    public UserDefinedMethodsViewController (int width,
                                             int height,
                                             CommandWindowContainerViewController commandWindowContainer) {
        super(width, height);
        applyTranslations();
        myCommandWindowContainer = commandWindowContainer;
        setTitle(myUserTranslation);
    }

    @Override
    public void applyTranslations () {
        myUserTranslation = GUIReferenceLibrary.getStringTranslation(User_KEY);
    }

    @Override
    public Node getNode () {
        return myPane;
    }

    /**
     * Update this view by replacing the entire list from the model
     */
    @Override
    public void update (MainModel model) {
        myListVerticalBox.getChildren().clear();
        UserDefinedCommandsModel userModel = model.getUserDefinedMethods();
        Set<String> userDefinedMethods = userModel.getAllDefinedCommands().keySet();
        for (String userDefinedMethod : userDefinedMethods) {
            addCommand(userDefinedMethod);
        }
    }
}
