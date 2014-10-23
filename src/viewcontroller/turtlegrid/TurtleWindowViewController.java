package viewcontroller.turtlegrid;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import model.MainModel;
import viewcontroller.MainModelObserver;
import viewcontroller.ViewController;
import application.Main;

/**
 * View Controller for Grid View (Where drawing and turtle is located on)
 * @author Jonathan Tseng
 *
 */
public class TurtleWindowViewController implements ViewController, MainModelObserver {

	public static final Dimension SIZE = new Dimension(Main.SIZE.width / 2 * 9/ 10, Main.SIZE.height * 9 / 10);
	
	private BorderPane myPane;
	private TurtleStatusViewController myStatusView;
	private GridViewController myGridView;
	private List<MainModelObserver> myChildObservers;
	
	public TurtleWindowViewController() {
		myChildObservers = new ArrayList<>();
		myPane = new BorderPane();
		myPane.setPrefSize(SIZE.width, SIZE.height);
		placeStatusView();
		placeGridView();
	}
	
	private void placeStatusView() {
		myStatusView = new TurtleStatusViewController();
		BorderPane.setAlignment(myStatusView.getNode(), Pos.CENTER);
		myPane.setBottom(myStatusView.getNode());
	}
	
	private void placeGridView() {
		myGridView = new GridViewController();
		myPane.setCenter(myGridView.getNode());
		myChildObservers.add(myGridView);
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
