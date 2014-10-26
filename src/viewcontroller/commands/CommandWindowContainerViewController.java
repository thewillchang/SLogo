package viewcontroller.commands;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.MainModel;
import viewcontroller.MainModelObserver;
import viewcontroller.MainViewController;
import viewcontroller.ViewController;
import application.Main;

/**
 * ViewController for containing all of the command windows (where
 * prompt/status/history/user-defined windows are located)
 * 
 * @author Abhishek B
 *
 */

public class CommandWindowContainerViewController implements ViewController,
		MainModelObserver {

	private static Dimension SIZE = new Dimension(
			Main.SIZE.width / 2 * 9 / 10, Main.SIZE.height * 9 / 10);

	private MainViewController myParent;
	private BorderPane myPane;
	private VBox myCommandWindowVerticalBox;
	private UserDefinedMethodsViewController myUserDefinedMethodsView;
	private UserDefinedVariablesViewController myUserDefinedVariablesView;
	private CommandHistoryViewController myCommandHistoryView;
	private CommandPromptViewController myCommandPromptView;
	private CommandStatusViewController myCommandStatusView;
	private List<MainModelObserver> myChildObservers;

	public CommandWindowContainerViewController(MainViewController parent) {
		myParent = parent;
		myChildObservers = new ArrayList<>();
		myPane = new BorderPane();
		myPane.setPrefSize(SIZE.width, SIZE.height);
		placeCommandWindows();
	}
	
	public void loadScript(String script) {
		myCommandPromptView.setCommandPromptText(script);
	}
	
	public void passSLogoCommand(String command) {
		myParent.passSLogoCommand(command);
	}
	
	public void passSLogoCommand(String commandKey, String operands) {
		myParent.passSLogoCommand(commandKey, operands);
	}

	private void placeCommandWindows() {
		myCommandWindowVerticalBox = new VBox(10);
		myCommandWindowVerticalBox.setPadding(new Insets(20));

		HBox userDefinedHorizontalBox = placeUserDefinedBoxes();
		myCommandHistoryView = new CommandHistoryViewController(
				SIZE.width, SIZE.height / 4, this);
		myCommandPromptView = new CommandPromptViewController(
				SIZE.width, SIZE.height / 4, this);
		myCommandStatusView = new CommandStatusViewController(
				SIZE.width, SIZE.height / 8);

		myCommandWindowVerticalBox.getChildren().addAll(
				userDefinedHorizontalBox, myCommandHistoryView.getNode(),
				myCommandPromptView.getNode(), myCommandStatusView.getNode());

		myChildObservers.add(myCommandHistoryView);
		myChildObservers.add(myCommandStatusView);

		myPane.setCenter(myCommandWindowVerticalBox);
	}

	private HBox placeUserDefinedBoxes() {
		HBox userDefinedHorizontalBox = new HBox();
		
		myUserDefinedMethodsView = new UserDefinedMethodsViewController(
				SIZE.width / 2, SIZE.height / 4, this);
		myUserDefinedVariablesView = new UserDefinedVariablesViewController(
				SIZE.width / 2, SIZE.height / 4, this);
		userDefinedHorizontalBox.getChildren().addAll(
				myUserDefinedMethodsView.getNode(),
				myUserDefinedVariablesView.getNode());
		myChildObservers.add(myUserDefinedMethodsView);
		myChildObservers.add(myUserDefinedVariablesView);
		return userDefinedHorizontalBox;
	}

	public void moveCommandTextToPromptWindow(String commandFromPrelists) {
		myCommandPromptView.appendCommandToPromptTextArea(commandFromPrelists);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(MainModel model) {
		for (MainModelObserver child : myChildObservers) {
			child.update(model);
		}
	}

	@Override
	public void applyTranslations() {
	}

}
