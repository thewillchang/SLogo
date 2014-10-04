package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;

/**
 * View Controller for Grid View (Where drawing and turtle is located on)
 * @author Jonathan Tseng
 *
 */
public class GridViewController implements Observer, ViewController {

	@Override
	public Node getNode() {
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
