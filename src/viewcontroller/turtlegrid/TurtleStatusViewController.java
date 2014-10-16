package viewcontroller.turtlegrid;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import viewcontroller.SLogoFont;
import viewcontroller.commands.CommandWindowViewController;

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
	
}
