package viewcontroller.commands;

import java.util.Map;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
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

	private TableView<Variable> table = new TableView<Variable>();
	private final ObservableList<Variable> data = FXCollections
			.observableArrayList(new Variable("x", 5), new Variable("y", 6));

	private Map<String, Double> myVariableMap;

	public UserDefinedVariablesViewController() {
		super();
		myTitleLabel.setText("User Defined Variables");
		myTitleLabel.setFont(new SLogoFont().createTextFont());
		placeVariableTable();
	}

	private void placeVariableTable() {
		table.setEditable(true);

		Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
			public TableCell call(TableColumn p) {
				return new EditingCell();
			}
		};

		TableColumn variableName = new TableColumn("Month");
		variableName
				.setCellValueFactory(new PropertyValueFactory<Variable, String>(
						"myVariableName"));

		TableColumn variableValue = new TableColumn("Value");
		variableValue
				.setCellValueFactory(new PropertyValueFactory<Variable, Double>(
						"myVariableValue"));

		variableValue.setCellFactory(cellFactory);
		variableValue
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Variable, Double>>() {
					@Override
					public void handle(
							TableColumn.CellEditEvent<Variable, Double> t) {
						((Variable) t.getTableView().getItems()
								.get(t.getTablePosition().getRow()))
								.setVariableValue(t.getNewValue());
					}
				});

		table.setItems(data);
		table.getColumns().addAll(variableName, variableValue);

		// table.setItems(data);
		// table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

		/*
		 * variableNameColumn = new TableColumn("Variable Name");
		 * variableNameColumn.setMinWidth(100);
		 * variableNameColumn.setCellValueFactory( new
		 * PropertyValueFactory<Variable, String>("myVariableName"));
		 * 
		 * variableValueColumn = new TableColumn("Value");
		 * variableValueColumn.setMinWidth(100);
		 * variableValueColumn.setCellValueFactory( new
		 * PropertyValueFactory<Variable, Double>("myVariableValue"));
		 */
		// myTable.setItems(data);
		// myTable.getColumns().addAll(variableNameColumn, variableValueColumn);	
		// myTable.getItems().add(new Variable("x", 5));
		//	myCommandWindowVerticalBox.getChildren().addAll(table);
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

	}

	public static class Variable {
		private final SimpleStringProperty myVariableName;
		private final SimpleDoubleProperty myVariableValue;

		private Variable(String name, double value) {
			this.myVariableName = new SimpleStringProperty(name);
			this.myVariableValue = new SimpleDoubleProperty(value);
		}

		public String getVariableName() {
			return myVariableName.get();
		}

		public void setVariableName(String name) {
			myVariableName.set(name);
		}

		public double getVariableValue() {
			return myVariableValue.get();
		}

		public void setVariableValue(double value) {
			myVariableValue.set(value);
		}
	}

	class EditingCell extends TableCell<Variable, Double> {

		private TextField textField;

		public EditingCell() {
		}

		@Override
		public void startEdit() {
			super.startEdit();

			if (textField == null) {
				createTextField();
			}

			setGraphic(textField);
			setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			textField.selectAll();
		}

		@Override
		public void cancelEdit() {
			super.cancelEdit();

			setText(String.valueOf(getItem()));
			setContentDisplay(ContentDisplay.TEXT_ONLY);
		}

		@Override
		public void updateItem(Double item, boolean empty) {
			super.updateItem(item, empty);

			if (empty) {
				setText(null);
				setGraphic(null);
			} else {
				if (isEditing()) {
					if (textField != null) {
						textField.setText(getString());
					}
					setGraphic(textField);
					setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
				} else {
					setText(getString());
					setContentDisplay(ContentDisplay.TEXT_ONLY);
				}
			}
		}

		private void createTextField() {
			textField = new TextField(getString());
			textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()
					* 2);
			textField.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent t) {
					if (t.getCode() == KeyCode.ENTER) {
						commitEdit(Double.parseDouble(textField.getText()));
					} else if (t.getCode() == KeyCode.ESCAPE) {
						cancelEdit();
					}
				}
			});
		}

		private String getString() {
			return getItem() == null ? "" : getItem().toString();
		}
	}

}
