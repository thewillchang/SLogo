package viewcontroller.commands;

import java.util.List;

import javafx.scene.Node;
import model.MainModel;
import model.UserDefinedCommandsModel;
import viewcontroller.GUIReferenceLibrary;
import viewcontroller.MainModelObserver;
import viewcontroller.SLogoFont;

/**
 * view controller for window for user defined methods
 * 
 * @author Abhishek B
 *
 */
public class UserDefinedMethodsViewController extends
		CommandClickableListWindowViewController implements MainModelObserver {

	private final String User = "UserMethods";
	
	public UserDefinedMethodsViewController(CommandWindowContainerViewController commandWindowContainer) {
		super();
		myCommandWindowContainer = commandWindowContainer;
		myTitleLabel.setText(GUIReferenceLibrary.getStringTranslation(User));
		myTitleLabel.setFont(new SLogoFont().createTextFont());
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(MainModel model) {
		myListVerticalBox.getChildren().clear();
		UserDefinedCommandsModel userModel = model.getUserDefinedMethods();
		List<String> userDefinedMethods = userModel.getDefinedCommands();
		for (String userDefinedMethod : userDefinedMethods) {
			addCommand(userDefinedMethod);
		}
	}
}
