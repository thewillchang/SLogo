package viewcontroller.turtlegrid;

import javafx.scene.Node;
import javafx.scene.control.Label;
import viewcontroller.GUIReferenceLibrary;
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
	private final String Status = "Turtle";
	private String myStatusTranslation;

	public TurtleStatusViewController() {
		super();
		myTitleLabel.setText(myStatusTranslation);
		myTitleLabel.setFont(new SLogoFont().createTextFont());

		myCommandWindowVerticalBox.getChildren().addAll(myTitleLabel, myLabel);
	}
		
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	protected void applyTranslations() {
		myStatusTranslation = GUIReferenceLibrary.getStringTranslation(Status);
	}
	
}
