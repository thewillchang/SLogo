package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * view controller for main view--contains rest of views and places them accordingly
 * @author Jonathan Tseng
 *
 */
public class MainViewController implements Observer, ViewController {

	private final static Insets myGridMargin = new Insets(25);
	
	private Scene myScene;
	private BorderPane myPane;
	private TurtleWindowViewController myGrid;
	
	public MainViewController() {
		myPane = new BorderPane();
		myScene = new Scene(myPane, Main.SIZE.width, Main.SIZE.height);
		placeGridViewController();
	}
	
	private void placeGridViewController() {
		myGrid = new TurtleWindowViewController();
		BorderPane.setAlignment(myGrid.getNode(), Pos.CENTER);
		BorderPane.setMargin(myGrid.getNode(), myGridMargin);
		myPane.setLeft(myGrid.getNode());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	public Scene getScene() {
		return myScene;
	}
	
}
