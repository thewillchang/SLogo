package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import model.MainModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import viewcontroller.commands.CommandWindowContainerViewController;
import viewcontroller.turtlegrid.TurtleWindowViewController;

/**
 * view controller for main view--contains rest of views and places them accordingly
 * @author Jonathan Tseng
 *
 */
public class MainViewController implements ViewController {

	private final static Insets GRID_MARGIN = new Insets(15);
	
	private BorderPane myPane;
	private TurtleWindowViewController myTurtleWindow;
	private CommandWindowContainerViewController myCommandWindow;
	
	public MainViewController(MainModel mainModel) {
		myPane = new BorderPane();
		placeTurtleWindowView();
		placeCommandWindowView(mainModel);
	}
	
	private void placeTurtleWindowView() {
		myTurtleWindow = new TurtleWindowViewController();
		BorderPane.setAlignment(myTurtleWindow.getNode(), Pos.CENTER);
		BorderPane.setMargin(myTurtleWindow.getNode(), GRID_MARGIN);
		myPane.setLeft(myTurtleWindow.getNode());
	}
	
	private void placeCommandWindowView(MainModel mainModel) {
		myCommandWindow = new CommandWindowContainerViewController(mainModel);
		BorderPane.setAlignment(myTurtleWindow.getNode(), Pos.CENTER);
		BorderPane.setMargin(myTurtleWindow.getNode(), GRID_MARGIN);
		myPane.setRight(myCommandWindow.getNode());
	}
	
	public void undoClicked() {
		myTurtleWindow.undoClicked();
	}
	
	public void redoClicked() {
		myTurtleWindow.redoClicked();
	}

	@Override
	public Node getNode() {
		return myPane;
	}
	
}
