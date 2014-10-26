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
import viewcontroller.SLogoFont;
import viewcontroller.ViewController;
/**
 * Abstract class for command window units
 * Sets up the BorderPane, overall VBox for ViewController elements,
 * TitleLabel, and the preferred size for this node.
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
		myTitleLabel = new Label();
		myCommandWindowVerticalBox = new VBox();
		myPane.setTop(myTitleLabel);
		myPane.setCenter(myCommandWindowVerticalBox);
	}
	
	protected void setTitle(String titleText){
		myTitleLabel.setText(titleText);
		myTitleLabel.setFont(new SLogoFont().createSubWindowTitleFont());
	}
}