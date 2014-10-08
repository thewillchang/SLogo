package viewcontroller;

import java.util.*;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * View controller for window of history of commands
 * @author Abhishek B
 *
 */
public class CommandHistoryViewController implements Observer, ViewController {

	private BorderPane myPane;
	private List<Label> myCommands;
	private VBox myWindowVerticalBox;
	private Label myTitleLabel;
	private VBox myListVerticalBox;
	
	public CommandHistoryViewController(){
		myPane = new BorderPane();
		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE, 
				new CornerRadii(0), new Insets(0))));
		
		myTitleLabel = new Label("Command History Window: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		
		placeCommandList();
		
		myWindowVerticalBox = new VBox();
		myWindowVerticalBox.getChildren().addAll(myTitleLabel, myListVerticalBox);
		
		myPane.setCenter(myWindowVerticalBox);
	}
	
	private void placeCommandList() {
		myListVerticalBox = new VBox();
		myCommands = new ArrayList<Label>();
		addCommand("fd 50");
		
		for(Label command: myCommands) {
			myListVerticalBox.getChildren().add(command);
		}
	}
	
	private void addCommand(String commandLabelString) {
		Label commandLabel = new Label(commandLabelString);
		commandLabel.setOnMouseClicked(new EventHandler<MouseEvent>(){
	          @Override
	          public void handle(MouseEvent arg0) {	            
	              commandLabel.setText("Selected: ");
	              System.out.println(" d");
	          }

	      });
		myCommands.add(commandLabel);
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}	
}
