package viewcontroller.commands;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.MainModel;
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

	private List<Label> myVariableLabels;
	private List<TextField> myTextInputs;
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
		addVariable("y");
	}

	/*
	 * private void addVariable(String variableLabelString) { Label
	 * variableLabel = new Label(variableLabelString);
	 * myVariableLabels.add(variableLabel);
	 * myListVerticalBox.getChildren().add(variableLabel); }
	 */

	protected void addVariable(String variableLabelString) {
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

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(MainModel model) {
		// TODO Auto-generated method stub
		
	}

}
