package viewcontroller.turtlegrid;

import java.awt.Dimension;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import viewcontroller.ViewController;
import application.Main;

/**
 * View Controller for Grid View (Where drawing and turtle is located on)
 * @author Jonathan Tseng
 *
 */
public class TurtleWindowViewController implements ViewController {

	public static final Dimension SIZE = new Dimension(Main.SIZE.width / 2 * 9/ 10, Main.SIZE.height * 9 / 10);
	
	private BorderPane myPane;
	private TurtleStatusViewController myStatusView;
	private GridViewController myGridView;
	
	public TurtleWindowViewController() {
		myPane = new BorderPane();
		myPane.setPrefSize(SIZE.width, SIZE.height);
		placeStatusView();
		placeGridView();
	}
	
	public void undoClicked() {
		myGridView.undo();
	}
	
	public void redoClicked() {
		myGridView.redo();
	}
	
	private void placeStatusView() {
		myStatusView = new TurtleStatusViewController();
		BorderPane.setAlignment(myStatusView.getNode(), Pos.CENTER);
		myPane.setBottom(myStatusView.getNode());
	}
	
	private void placeGridView() {
		myGridView = new GridViewController();
		myPane.setCenter(myGridView.getNode());
	}
	
	
	@Override
	public Node getNode() {
		return myPane;
	}

}
