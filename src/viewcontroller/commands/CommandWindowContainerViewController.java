package viewcontroller.commands;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.MainModel;
import viewcontroller.MainModelObserver;
import viewcontroller.ViewController;
import application.Main;

/**
 * ViewController for containing all of the command windows
 * (where prompt/status/history/user-defined windows are located) 
 * @author Abhishek B
 *
 */

public class CommandWindowContainerViewController implements ViewController, MainModelObserver {

	public static final Dimension SIZE = new Dimension(
			Main.SIZE.width / 2 * 9 / 10, Main.SIZE.height * 9 / 10);

	private MainModel myMainModel;
	private BorderPane myPane;
	private VBox commandWindowVerticalBox;
	private UserDefinedMethodsViewController myUserDefinedMethodsView;
	private UserDefinedVariablesViewController myUserDefinedVariablesView;
	private CommandHistoryViewController myCommandHistoryView;
	private CommandPromptViewController myCommandPromptView;
	private CommandStatusViewController myCommandStatusView;
	private List<MainModelObserver> myChildObservers;

	public CommandWindowContainerViewController(MainModel mainModel) {
		myChildObservers = new ArrayList<>();
		myMainModel = mainModel;
		myPane = new BorderPane();
		myPane.setPrefSize(SIZE.width, SIZE.height);
		placeCommandWindows();
	}
	
	private void placeCommandWindows() {
		commandWindowVerticalBox = new VBox(10);
		commandWindowVerticalBox.setPadding(new Insets(20));
		
		HBox userDefinedHorizontalBox = placeUserDefinedBoxes();
		myCommandHistoryView = new CommandHistoryViewController(this);
		myCommandPromptView = new CommandPromptViewController(myMainModel);
		myCommandStatusView = new CommandStatusViewController();
		
		VBox.setVgrow(userDefinedHorizontalBox, Priority.ALWAYS);
		VBox.setVgrow(myCommandHistoryView.getNode(), Priority.ALWAYS);
		VBox.setVgrow(myCommandPromptView.getNode(), Priority.ALWAYS);
		VBox.setVgrow(myCommandStatusView.getNode(), Priority.ALWAYS); 
		commandWindowVerticalBox.getChildren().addAll(userDefinedHorizontalBox, myCommandHistoryView.getNode(), 
				myCommandPromptView.getNode(), myCommandStatusView.getNode());
		
		myChildObservers.add(myCommandHistoryView);
		myChildObservers.add(myCommandStatusView);
		
		myPane.setCenter(commandWindowVerticalBox);
	}
	
	private HBox placeUserDefinedBoxes() {
		HBox userDefinedHorizontalBox = new HBox();
		myUserDefinedMethodsView = new UserDefinedMethodsViewController(this);
		myUserDefinedVariablesView = new UserDefinedVariablesViewController();
		HBox.setHgrow(myUserDefinedMethodsView.getNode(), Priority.ALWAYS);
		HBox.setHgrow(myUserDefinedVariablesView.getNode(), Priority.ALWAYS);
		userDefinedHorizontalBox.getChildren().addAll(myUserDefinedMethodsView.getNode(), myUserDefinedVariablesView.getNode());
		myChildObservers.add(myUserDefinedMethodsView);
		myChildObservers.add(myUserDefinedVariablesView);
		return userDefinedHorizontalBox;
	}
	
	public void updateCommandWindow(String commandFromPrelists) {
		myCommandPromptView.appendCommandToPromptTextArea(commandFromPrelists);
	}
	
	public void updateStatusWindow(String commandFromPromptTextArea) {
		myCommandStatusView.updateCommandStatusText(commandFromPromptTextArea);
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

}
