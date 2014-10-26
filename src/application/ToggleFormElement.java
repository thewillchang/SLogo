package application;

import viewcontroller.SLogoFont;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;

public class ToggleFormElement extends ToggleButton implements FormElement {

	public boolean mySelected;
	public String myOnLabel;
	public String myOffLabel;
	
	public ToggleFormElement(String on, String off) {
		super(off);
		setFont(new SLogoFont().createTextFont());
		myOnLabel = on;
		myOffLabel = off;
		this.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable,
					Boolean oldValue, Boolean newValue) {
				String label = (newValue) ? myOnLabel : myOffLabel;
				setText(label);
			}
		});
	}

	public void setInitialValue(boolean on) {
		setSelected(on);
	}
	
	@Override
	public Node getNode() {
		return this;
	}

	@Override
	public String getSelectedValue() {
		return this.getText();
	}

}
