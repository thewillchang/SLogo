package viewcontroller.commands;

import java.awt.Dimension;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import viewcontroller.ViewController;

/**
 * Abstract class for command window units
 * 
 * @author Abhishek B
 *
 */
public abstract class CommandWindowViewController implements ViewController {

	protected BorderPane myPane;
	protected VBox myCommandWindowVerticalBox;
	protected Label myTitleLabel;
	protected Dimension SIZE = new Dimension();

	public CommandWindowViewController(int width, int height) {
		myPane = new BorderPane();
		myPane.setPrefSize(width, height);
		SIZE.width = width;
		SIZE.height = height;
		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE,
				new CornerRadii(0), new Insets(0))));
		myCommandWindowVerticalBox = new VBox();
		myTitleLabel = new Label();
		myCommandWindowVerticalBox.getChildren().add(myTitleLabel);
		myPane.setCenter(myCommandWindowVerticalBox);
	}

	protected abstract void applyTranslations();
}
