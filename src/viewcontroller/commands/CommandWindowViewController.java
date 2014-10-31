package viewcontroller.commands;

import java.awt.Dimension;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import viewcontroller.GUIReferenceLibrary;
import viewcontroller.SLogoFont;
import viewcontroller.ViewController;

/**
 * Abstract class for command window units Sets up the BorderPane, overall VBox
 * for ViewController elements, TitleLabel, and the preferred size for this
 * node.
 * 
 * @author Abhishek B
 *
 */
public abstract class CommandWindowViewController implements ViewController {
	protected BorderPane myPane;
	protected VBox myCommandWindowVerticalBox;
	protected Label myTitleLabel;
	protected Dimension SIZE = new Dimension();

	private static String PANE_KEY = "pane";
	private static String TEXT_KEY = "text";
	private static String VBOX_KEY = "vbox";

	public CommandWindowViewController(int width, int height) {
		myPane = new BorderPane();
		myPane.setPrefSize(width, height);
		addStyleSheets();
		SIZE.width = width;
		SIZE.height = height;
		myPane.getStyleClass().add(PANE_KEY);
		myTitleLabel = new Label();
		myCommandWindowVerticalBox = new VBox();
		myPane.setTop(myTitleLabel);
		myPane.setCenter(myCommandWindowVerticalBox);
	}

	/**
	 * Back up elements in this by CSS files
	 */
	private void addStyleSheets() {
		myPane.getStylesheets().add(GUIReferenceLibrary.getPath(PANE_KEY));
		myPane.getStylesheets().add(GUIReferenceLibrary.getPath(TEXT_KEY));
		myPane.getStylesheets().add(GUIReferenceLibrary.getPath(VBOX_KEY));
	}

	protected void setTitle(String titleText) {
		myTitleLabel.setText(titleText);
		myTitleLabel.setFont(new SLogoFont().createSubWindowTitleFont());
	}
}