package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;


/**
 * view controller for status of turtle that can be toggled
 * i.e., view that shows turtle position
 * @author Jonathan Tseng
 *
 */
public class TurtleStatusViewController implements Observer, ViewController {

	private Label myLabel;
	
	public TurtleStatusViewController() {
		myLabel = new Label("Turtle Status: ");
		myLabel.setFont(new SLogoFont().createTextFont());
		myLabel.setAlignment(Pos.CENTER);
		myLabel.setPadding(new Insets(10));
	}
	
	@Override
	public Node getNode() {
		return myLabel;
	}

	@Override
	public void update(Observable o, Object arg) {

	}

}
