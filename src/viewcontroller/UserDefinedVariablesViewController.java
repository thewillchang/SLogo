package viewcontroller;

import java.util.ArrayList;
import java.util.List;
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
 * view controller for window for user defined variables 
 * @author Abhishek B
 *
 */
public class UserDefinedVariablesViewController implements Observer, ViewController {

	private BorderPane myPane;
	private List<Label> myVariableLabels;
	private VBox myWindowVerticalBox;
	private Label myTitleLabel;
	private VBox myListVerticalBox;
	
	public UserDefinedVariablesViewController() {
		myPane = new BorderPane();
		myPane.setBackground(new Background(new BackgroundFill(Color.WHITE, 
				new CornerRadii(0), new Insets(0))));
		
		myTitleLabel = new Label("User Defined Variables: ");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		
		placeVariableList();

		myWindowVerticalBox = new VBox();
		myWindowVerticalBox.getChildren().addAll(myTitleLabel, myListVerticalBox);
		
		myPane.setCenter(myWindowVerticalBox);
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
