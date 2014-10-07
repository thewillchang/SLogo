package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * View Controller for the Text input where user types commands
 * @author Jonathan Tseng
 *
 */
public class CommandPromptViewController implements Observer, ViewController {

	private BorderPane myPane;
	
	public CommandPromptViewController(){
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
