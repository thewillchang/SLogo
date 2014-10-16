package viewcontroller.commands;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import viewcontroller.SLogoFont;

/**
 * View Controller for status text for SLogo commands
 * @author Abhishek B
 *
 */
public class CommandStatusViewController extends CommandWindowViewController {

	private Label myStatusLabel;
	
	public CommandStatusViewController(){
		myTitleLabel.setText("Command Status");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		
		myStatusLabel = new Label(">>");
		myStatusLabel.setFont(new SLogoFont().createTextFont());
		myStatusLabel.setPadding(new Insets(0));
		
		myCommandWindowVerticalBox.getChildren().add(myStatusLabel);
	}
	
	public void updateCommandStatusText(String commandResult){
		myStatusLabel.setText(commandResult);
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

}
