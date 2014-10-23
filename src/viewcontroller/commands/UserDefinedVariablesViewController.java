package viewcontroller.commands;

import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.MainModel;
import model.UserDefinedVariablesModel;
import viewcontroller.MainModelObserver;
import viewcontroller.SLogoFont;

/**
 * View controller for window for user defined variables
 * 
 * @author Abhishek B
 *
 */
public class UserDefinedVariablesViewController extends
		CommandWindowViewController implements MainModelObserver {

	private VBox myListVerticalBox;
	private Map<String, Double> myVariableMap;
	
	public UserDefinedVariablesViewController() {
		super();
		myTitleLabel.setText("User Defined Variables");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		myPane.setTop(myTitleLabel);
		placeVariableTable();
	}

	private void placeVariableTable() {
		myListVerticalBox = new VBox();
		addVariableToList("x", 5);
		myPane.setCenter(myListVerticalBox);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(MainModel model) {
		UserDefinedVariablesModel myModel = model.getUserDefinedVariables();
		myVariableMap = myModel.getVariables();
		updateVariableList();
	}

	private void updateVariableList() {
		for(String variable : myVariableMap.keySet()) {
			addVariableToList(variable, myVariableMap.get(variable));
		}
	}
	
	private void addVariableToList(String variable, double value) {
		Label variableLabel = new Label(variable);
		Label valueLabel = new Label(Double.toString(value));
		valueLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				TextField editableVariableLabel = new TextField(variableLabel.getText());
				editableVariableLabel.setOnKeyPressed(new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent arg0) {
						if (arg0.getCode() == KeyCode.ENTER) {
							valueLabel.setText(editableVariableLabel.getText());
							myListVerticalBox.getChildren().remove(editableVariableLabel);
							myListVerticalBox.getChildren().add(valueLabel);
						}
					}
				});
			}
		});
		HBox variableHorizontalBox = new HBox();
		variableHorizontalBox.setPrefWidth(200);
		variableHorizontalBox.getChildren().addAll(variableLabel, valueLabel);
		myListVerticalBox.getChildren().add(variableHorizontalBox);
	}
}
