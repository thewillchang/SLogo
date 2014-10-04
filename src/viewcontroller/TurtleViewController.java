package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;

/**
 * view controller for an individual turtle object
 * @author Jonathan Tseng
 *
 */
public class TurtleViewController implements Observer, ViewController {

	@Override
	public Node getNode() {
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
