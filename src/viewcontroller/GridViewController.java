package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GridViewController implements Observer, ViewController {

	private BorderPane myPane;
	private Group myGrid;
	
	public GridViewController() {
		myPane = new BorderPane();
		myPane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, 
				new CornerRadii(0), new Insets(0))));
		myGrid = new Group();
		//myPane.setCenter(myGrid);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
