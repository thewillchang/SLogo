package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;

/**
 * view controller for main view--contains rest of views and places them accordingly
 * @author Jonathan Tseng
 *
 */
public class MainViewController implements Observer, ViewController {

	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	public Node getNode() {
		return null;
	}

}
