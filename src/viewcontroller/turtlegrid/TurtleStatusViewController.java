package viewcontroller.turtlegrid;

import model.MainModel;
import javafx.scene.Node;
import viewcontroller.GUIReferenceLibrary;
import viewcontroller.MainModelObserver;
import viewcontroller.SLogoFont;
import viewcontroller.commands.CommandWindowViewController;

/**
 * view controller for status of turtle that can be toggled i.e., view that
 * shows turtle position
 * 
 * @author Jonathan Tseng, Abhishek Balakrishnan
 *
 */
public class TurtleStatusViewController extends CommandWindowViewController implements MainModelObserver {

	private final String Status = "Turtle";
	private String myStatusTranslation;

	public TurtleStatusViewController(int width, int height) {
		super(width, height);
		applyTranslations();
		myTitleLabel.setText(myStatusTranslation);
		myTitleLabel.setFont(new SLogoFont().createTextFont());
	}
		
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	protected void applyTranslations() {
		myStatusTranslation = GUIReferenceLibrary.getStringTranslation(Status);
	}

	@Override
	public void update(MainModel model) {
		applyTranslations();
	}
	
}
