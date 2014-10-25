package viewcontroller.commands;

import java.util.Map;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

	private final static String MAKE_KEY = "MakeVariable";
	
	private VBox myListVerticalBox;
	private CommandWindowContainerViewController myParent;
	private Map<String, Double> myVariableMap;
	private final String UserVariables = "UserVariables";
	private String myUserTranslation;

	public UserDefinedVariablesViewController(int width, int height,
			CommandWindowContainerViewController parent) {
		super(width, height);
		myParent = parent;
		applyTranslations();
		myTitleLabel.setText(myUserTranslation);
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		placeVariableTable();
	}

	@Override
	public void applyTranslations() {
		myUserTranslation = GUIReferenceLibrary
				.getStringTranslation(UserVariables);
	}

	private void placeVariableTable() {
		myListVerticalBox = new VBox();
		myCommandWindowVerticalBox.getChildren().add(myListVerticalBox);
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(MainModel model) {
		UserDefinedVariablesModel myUserDefinedVariablesModel = model.getUserDefinedVariables();
		applyTranslations();
		myVariableMap = myUserDefinedVariablesModel.getAllVariables();
		updateVariableList();
	}

	private void updateVariableList() {
		myListVerticalBox.getChildren().clear();
		for (String variable : myVariableMap.keySet()) {
			addVariableToList(variable, myVariableMap.get(variable));
		}
	}

	private void addVariableToList(String variable, double value) {
		HBox variableHBox = new HBox(100);
		variableHBox.setPrefSize(SIZE.width, SIZE.height / 6);
		Label variableLabel = new Label(variable);
		Label valueLabel = new Label(Double.toString(value));
		variableHBox.getChildren().addAll(variableLabel, valueLabel);
		valueLabel.setOnMouseClicked(event->variableClicked(variableHBox, variableLabel, valueLabel));
				
//				new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent arg0) {
//				TextField editableValueLabel = new TextField(valueLabel
//						.getText());
//				variableHorizontalBox.getChildren().remove(valueLabel);
//				variableHorizontalBox.getChildren().add(editableValueLabel);
//				editableValueLabel
//						.setOnKeyPressed(new EventHandler<KeyEvent>() {
//							@Override
//							public void handle(KeyEvent arg0) {
//								if (arg0.getCode() == KeyCode.ENTER) {
//									valueLabel.setText(editableValueLabel
//											.getText());
//									myMainModel.updateUserDefinedVariable(
//											variableLabel.getText(), Double
//													.parseDouble(valueLabel
//															.getText()));
//									variableHorizontalBox.getChildren().remove(
//											editableValueLabel);
//									variableHorizontalBox.getChildren().add(
//											valueLabel);
//								}
//							}
//						});
//			}
//		});
		myListVerticalBox.getChildren().add(variableHBox);
	}
	
	private void variableClicked(HBox variableHBox, Label variableLabel, Label valueLabel) {
		TextField editableValueLabel = new TextField(valueLabel
				.getText());
		variableHBox.getChildren().remove(valueLabel);
		variableHBox.getChildren().add(editableValueLabel);
		editableValueLabel.setOnKeyPressed(event->keyPressed(
				event, 
				editableValueLabel, 
				variableHBox, 
				variableLabel, 
				valueLabel));
	}
	
	private void keyPressed(KeyEvent event, TextField editableValueLabel, HBox variableHBox, Label variableLabel, Label valueLabel) {
		if (event.getCode() == KeyCode.ENTER) {
			valueLabel.setText(editableValueLabel.getText());
			myParent.passSLogoCommand(MAKE_KEY, variableLabel.getText().trim() + " " + valueLabel.getText().trim());
			variableHBox.getChildren().remove(editableValueLabel);
			variableHBox.getChildren().add(valueLabel);
		}
	}
	
}
