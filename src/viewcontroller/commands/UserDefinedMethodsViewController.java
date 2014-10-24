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
	private String myUserTranslation;
	
	public UserDefinedMethodsViewController(int width, int height, CommandWindowContainerViewController commandWindowContainer) {
		super(width, height);
		applyTranslations();
		myCommandWindowContainer = commandWindowContainer;
		myTitleLabel.setText(myUserTranslation);
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		addCommand("cry 1 hr");
	}

	@Override
	protected void applyTranslations() {
		myUserTranslation = GUIReferenceLibrary.getStringTranslation(User);
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
