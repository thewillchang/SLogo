package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * View controller for window of history of commands
 * @author Jonathan Tseng
 *
 */
public class CommandHistoryViewController implements Observer, ViewController {

	private BorderPane myPane;
	
	public CommandHistoryViewController(){
		myPane = new BorderPane();
//		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE, 
//				new CornerRadii(0), new Insets(0))));
		
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
