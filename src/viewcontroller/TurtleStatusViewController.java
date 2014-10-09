package viewcontroller;

import java.util.Observable;
import viewcontroller.commands.CommandWindowViewController;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * view controller for status of turtle that can be toggled i.e., view that
 * shows turtle position
 * 
 * @author Jonathan Tseng
 *
 */
public class TurtleStatusViewController extends CommandWindowViewController {

	private Label myLabel;

	public TurtleStatusViewController() {
		super();
		myTitleLabel.setText("Turtle Status");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		myLabel = new Label("jdaklas");
		myLabel.setPadding(new Insets(10));

		myCommandWindowVerticalBox.getChildren().add(myLabel);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {

	}

}
