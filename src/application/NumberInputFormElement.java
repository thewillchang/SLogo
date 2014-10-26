package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import viewcontroller.SLogoFont;

/**
 * form element for number input text field
 * @author Jonathan Tseng
 *
 */
public class NumberInputFormElement extends HBox implements FormElement {

	private TextField myNumberField;
	
	public NumberInputFormElement(String prompt) {
		this.setSpacing(10);
		this.setPadding(new Insets(10));
		Label myLabel = new Label(prompt);
		myLabel.setFont(new SLogoFont().createTextFont());
		getChildren().add(myLabel);
		myNumberField = new TextField();
		getChildren().add(myNumberField);
	}
	
	public void setInitialValue(double value) {
		myNumberField.setText(Double.toString(value));
	}
	
	@Override
	public Node getNode() {
		return this;
	}

	@Override
	public String getSelectedValue() {
		return myNumberField.getText();
	}

}
