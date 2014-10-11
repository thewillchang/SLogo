package viewcontroller.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import viewcontroller.SLogoFont;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * view controller for window for user defined variables 
 * @author Abhishek B
 *
 */
public class UserDefinedVariablesViewController extends CommandWindowViewController {

	private List<Label> myVariableLabels;
	private VBox myListVerticalBox;
	
	public UserDefinedVariablesViewController() {
		super();
		
		myTitleLabel.setText("User Defined Variables");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
			
		placeVariableList();

		myCommandWindowVerticalBox.getChildren().addAll(myListVerticalBox);
	}
	
	private void placeVariableList() {
		myListVerticalBox = new VBox();
		myVariableLabels = new ArrayList<Label>();
		addVariable("x");
	}
	
	private void addVariable(String variableLabelString) {
		Label variableLabel = new Label(variableLabelString);
		myVariableLabels.add(variableLabel);
		myListVerticalBox.getChildren().add(variableLabel);
	}
	
	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
