package viewcontroller.turtlegrid;

import model.MainModel;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	private final String TurtleID = "TurtleID";
	private final String XPosition = "XPosition";
	private final String YPosition = "YPosition";
	private String myStatusTranslation;
	private String myTurtleID;
	private String myXPosition;
	private String myYPosition;
	private VBox myListVerticalBox;
	private HBox myColumnTitles;
	private HBox myTurtleData;

	public TurtleStatusViewController(int width, int height) {
		super(width, height);
		applyTranslations();
		myTitleLabel.setText(myStatusTranslation);
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		placeVariableTable();
	}
	
	private void placeVariableTable() {
		myListVerticalBox = new VBox();
		myColumnTitles = populateHBox(myTurtleID, myXPosition, myYPosition);
		myTurtleData = new HBox(10);
		myListVerticalBox.getChildren().addAll(myColumnTitles, myTurtleData);
	}
	
	private HBox populateHBox(String turtleID, String xPosition, String yPosition) {
		HBox statusRow = new HBox(10);
		statusRow.setPrefSize(SIZE.width, SIZE.height/3);
		statusRow.getChildren().addAll(new Label(turtleID), new Label(xPosition), new Label(yPosition));
		return statusRow;
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void applyTranslations() {
		myStatusTranslation = GUIReferenceLibrary.getStringTranslation(Status);
		myTurtleID = GUIReferenceLibrary.getStringTranslation(TurtleID);
		myXPosition = GUIReferenceLibrary.getStringTranslation(XPosition);
		myYPosition = GUIReferenceLibrary.getStringTranslation(YPosition);
	}

	@Override
	public void update(MainModel model) {
		int turtleID = 0;
		double xPosition = 0;
		double yPosition = 0;
		String turtleIDString = Integer.toString(turtleID);
		String xPositionString = Double.toString(xPosition);
		String yPositionString = Double.toString(yPosition);
		
		myTurtleData = populateHBox(turtleIDString, xPositionString, yPositionString);
	}
	
}
