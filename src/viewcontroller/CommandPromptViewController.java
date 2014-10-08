package viewcontroller;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * View Controller for the Text input where user types commands
 * @author Jonathan Tseng
 *
 */
public class CommandPromptViewController implements Observer, ViewController {

	private BorderPane myPane;
	private Label myTitleLabel;
	private VBox myWindowVerticalBox;
	private TextArea myCommandTextArea;
	
	public CommandPromptViewController(){
		myPane = new BorderPane();
		
		myTitleLabel = new Label("Prompt: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		myTitleLabel.setPadding(new Insets(10));
		
		TextArea myCommandTextArea = new TextArea();
		myCommandTextArea.setPrefRowCount(4);
		myCommandTextArea.setWrapText(true);
		
		myWindowVerticalBox = new VBox();
		myWindowVerticalBox.getChildren().addAll(myTitleLabel, myCommandTextArea);
		
		myPane.setCenter(myWindowVerticalBox);
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
