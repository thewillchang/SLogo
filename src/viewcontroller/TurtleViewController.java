package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;

public class TurtleViewController implements Observer, ViewController {

	@Override
	public Node getNode() {
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
