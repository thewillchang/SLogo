package viewcontroller.commands;

import interpreter.expression.SLogoExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.MainModel;
import model.UserDefinedVariablesModel;
import viewcontroller.MainModelObserver;
import viewcontroller.SLogoFont;

/**
 * view controller for window for user defined variables
 * 
 * @author Abhishek B
 *
 */
public class UserDefinedVariablesViewController extends
		CommandWindowViewController implements MainModelObserver {

	private Map<String, Double> myVariableMap;	
	private TableView myTable;

	public UserDefinedVariablesViewController() {
		super();
		myTitleLabel.setText("User Defined Variables");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		placeVariableTable();
	}

	private void placeVariableTable() {
		myTable = new TableView();
		myTable.setEditable(true);
		TableColumn variableNameColumn = new TableColumn("Variable Name");
		TableColumn variableValueColumn = new TableColumn("Value");
		myTable.getColumns().addAll(variableNameColumn, variableValueColumn);
		myCommandWindowVerticalBox.getChildren().addAll(myTable);
//		addVariable("x");
//		addVariable("y");
	}

/*	protected void addVariable(String variableLabelString) {
		Label variableLabel = new Label(variableLabelString);
		variableLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				TextField editableVariableLabel = new TextField(variableLabel.getText());
				editableVariableLabel.setOnKeyPressed(new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent arg0) {
						if (arg0.getCode() == KeyCode.ENTER) {
							variableLabel.setText(editableVariableLabel.getText());
							myListVerticalBox.getChildren().remove(editableVariableLabel);
							myListVerticalBox.getChildren().add(variableLabel);
						}
					}
				});
				myListVerticalBox.getChildren().remove(variableLabel);
				myListVerticalBox.getChildren().add(editableVariableLabel);
			}
		});
		myVariableLabels.add(variableLabel);
		myListVerticalBox.getChildren().add(variableLabel);
	}
*/
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
		
	}

}
