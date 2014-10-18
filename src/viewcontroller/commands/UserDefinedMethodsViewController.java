package viewcontroller.commands;

import java.util.List;
import javafx.scene.Node;
import model.MainModel;
import model.UserDefinedMethodsModel;
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

	public UserDefinedMethodsViewController(CommandWindowContainerViewController commandWindowContainer) {
		super();
		myCommandWindowContainer = commandWindowContainer;
		myTitleLabel.setText("User Defined Methods: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(MainModel model) {
		myListVerticalBox.getChildren().clear();
		UserDefinedMethodsModel userModel = model.getUserDefinedMethods();
		List<String> userDefinedMethods = userModel.getMethods();
		for (String userDefinedMethod : userDefinedMethods) {
			addCommand(userDefinedMethod);
		}
	}
}
