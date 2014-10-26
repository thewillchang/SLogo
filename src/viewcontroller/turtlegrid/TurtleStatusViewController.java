package viewcontroller.turtlegrid;

import model.MainModel;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import turtle.Turtle;
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
public class TurtleStatusViewController extends CommandWindowViewController
		implements MainModelObserver {

	private final String Status = "Status";
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
		myCommandWindowVerticalBox.getChildren().addAll(myListVerticalBox);
	}

	private void placeVariableTable() {
		myListVerticalBox = new VBox();
		myColumnTitles = populateHBox(myTurtleID, myXPosition, myYPosition);
		myTurtleData = populateHBox(" ", " ", " ");
		myListVerticalBox.getChildren().addAll(myColumnTitles, myTurtleData);
	}

	private HBox populateHBox(String turtleID, String xPosition,
			String yPosition) {
		HBox statusRow = new HBox(50);
<<<<<<< HEAD
		statusRow.setPrefSize(SIZE.width, SIZE.height/3);
		statusRow.getChildren().addAll(new Label(turtleID), new Label(xPosition), new Label(yPosition));
=======
		statusRow.setPrefSize(SIZE.width, SIZE.height / 2);
		statusRow.getChildren().addAll(new Label(turtleID),
				new Label(xPosition), new Label(yPosition));
>>>>>>> origin/abhishekBranch
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
		try {
			Turtle turtle = model.getActiveTurtle();
			if (turtle == null) {
				throw new NullPointerException();
			}
			String turtleIDString = Integer.toString(turtle.getId());
			String xPositionString = Double.toString(turtle.getX());
			String yPositionString = Double.toString(turtle.getY());

			myTurtleData = populateHBox(turtleIDString, xPositionString,
					yPositionString);
		} catch (NullPointerException npe) {
			myTurtleData = populateHBox("No Turtle Selected", "0", "0");
		}
	}

}
