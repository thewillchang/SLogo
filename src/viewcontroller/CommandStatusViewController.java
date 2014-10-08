package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * View Controller for status text for SLogo commands
 * @author Jonathan Tseng
 *
 */
public class CommandStatusViewController implements Observer, ViewController {

	private BorderPane myPane;
	private VBox myCommandStatusWindowVerticalBox;
	private Label myTitleLabel;
	private Label myStatusLabel;
	
	public CommandStatusViewController(){
		myPane = new BorderPane();
		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE, 
				new CornerRadii(0), new Insets(0))));
		
		myCommandStatusWindowVerticalBox = new VBox();

		myTitleLabel = new Label("Command Status: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		
		myStatusLabel = new Label(">>");
		myStatusLabel.setFont(new SLogoFont().createTextFont());
		myStatusLabel.setPadding(new Insets(0));
		
		myCommandStatusWindowVerticalBox.getChildren().addAll(myTitleLabel, myStatusLabel);
		myPane.setCenter(myCommandStatusWindowVerticalBox);
	}
	
	public void updateCommandStatusText(String commandResult){
		myStatusLabel.setText(commandResult);
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
