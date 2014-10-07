package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * View Controller for status text for SLogo commands
 * @author Jonathan Tseng
 *
 */
public class CommandStatusViewController implements Observer, ViewController {

	private BorderPane myPane;
	
	public CommandStatusViewController(){
		myPane = new BorderPane();
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
