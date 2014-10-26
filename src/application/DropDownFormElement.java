package application;

import java.util.Collection;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import viewcontroller.SLogoFont;

public class DropDownFormElement extends ComboBox<String> implements FormElement {

	public DropDownFormElement(Collection<String> choices) {
		this.setStyle(new SLogoFont().createButtonFontStyle());
		this.getItems().addAll(choices);
	}
	
	public void setInitialValue(String choice) {
		this.getSelectionModel().select(choice);
	}
	
	@Override
	public Node getNode() {
		return this;
	}

	@Override
	public String getSelectedValue() {
		return this.getValue();
	}

}
