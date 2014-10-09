package viewcontroller.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import viewcontroller.SLogoFont;
import viewcontroller.ViewController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * view controller for window for user defined methods
 * 
 * @author Abhishek B
 *
 */
public class UserDefinedMethodsViewController implements Observer,
		ViewController {

	private BorderPane myPane;
	private List<Label> myCommands;
	private VBox myWindowVerticalBox;
	private Label myTitleLabel;
	private VBox myListVerticalBox;
	private CommandWindowViewController myCommandWindow;

	public UserDefinedMethodsViewController(
			CommandWindowViewController commandWindow) {
		myCommandWindow = commandWindow;
		myPane = new BorderPane();
		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE,
				new CornerRadii(0), new Insets(0))));

		myTitleLabel = new Label("User Defined Methods: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());

		placeCommandList();

		myWindowVerticalBox = new VBox();
		myWindowVerticalBox.getChildren().addAll(myTitleLabel,
				myListVerticalBox);

		myPane.setCenter(myWindowVerticalBox);
	}

	private void placeCommandList() {
		myListVerticalBox = new VBox();
		myCommands = new ArrayList<Label>();
		addCommand("sit 50");

		for (Label command : myCommands) {
			myListVerticalBox.getChildren().add(command);
		}
	}

	private void addCommand(String commandLabelString) {
		Label commandLabel = new Label(commandLabelString);
		commandLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				myCommandWindow.updateCommandWindow(commandLabelString);
			}

		});
		myCommands.add(commandLabel);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {

	}

}
