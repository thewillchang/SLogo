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
import viewcontroller.GUIReferenceLibrary;
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
	private final String UserVariables = "UserVariables";
	
	public UserDefinedVariablesViewController() {
		super();
		myTitleLabel.setText(GUIReferenceLibrary.getStringTranslation(UserVariables));
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		myPane.setTop(myTitleLabel);
		placeVariableTable();
	}

	private void placeVariableTable() {
		myListVerticalBox = new VBox();
		addVariableToList("x", 5);
		addVariableToList("y", 10);
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
		myListVerticalBox.getChildren().clear();
		for(String variable : myVariableMap.keySet()) {
			addVariableToList(variable, myVariableMap.get(variable));
		}
	}
	
	private void addVariableToList(String variable, double value) {
		Label variableLabel = new Label(variable);
		Label valueLabel = new Label(Double.toString(value));
		HBox variableHorizontalBox = new HBox(10);
		variableHorizontalBox.getChildren().addAll(variableLabel, valueLabel);
		valueLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				TextField editableValueLabel = new TextField(valueLabel.getText());
				variableHorizontalBox.getChildren().remove(valueLabel);
				variableHorizontalBox.getChildren().add(editableValueLabel);
				editableValueLabel.setOnKeyPressed(new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent arg0) {
						if (arg0.getCode() == KeyCode.ENTER) {
							valueLabel.setText(editableValueLabel.getText());
							// TODO: Need to send this information back to the model
							variableHorizontalBox.getChildren().remove(editableValueLabel);
							variableHorizontalBox.getChildren().add(valueLabel);
						}
					}
				});
			}
		});
		myListVerticalBox.getChildren().add(variableHorizontalBox);
	}
}
