package viewcontroller.turtlegrid;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class SLogoColorPicker extends SLogoLabeledContainer {

	private ColorPicker myColorPicker;
	
	public SLogoColorPicker(String label, Color color, EventHandler<ActionEvent> handler) {
		super(label);
		createColorPicker(color, handler);
		addNode(myColorPicker);
	}
	
	private void createColorPicker(Color color, EventHandler<ActionEvent> handler) {
		myColorPicker = new ColorPicker(color);
		myColorPicker.getStyleClass().add("button");
		myColorPicker.setOnAction(handler);
	}	
	
	public Color getColor() {
		return myColorPicker.getValue();
	}
	
}
