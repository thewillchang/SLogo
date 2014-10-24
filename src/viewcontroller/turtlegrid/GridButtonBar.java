package viewcontroller.turtlegrid;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class GridButtonBar extends HBox {

	private SLogoColorPicker myGridColorPicker;
	private SLogoColorPicker myPenColorPicker;
	
	public GridButtonBar(EventHandler<ActionEvent> gridColorEventHandler, EventHandler<ActionEvent> penColorEventHandler) {
		this.setSpacing(5);
		this.setPadding(new Insets(5));
		this.setAlignment(Pos.CENTER);
		myGridColorPicker = new SLogoColorPicker("Grid Color", gridColorEventHandler);
		myPenColorPicker = new SLogoColorPicker("Pen Color", penColorEventHandler);
		placeColorPickers();
	}
	
	private void placeColorPickers() {
		getChildren().addAll(myGridColorPicker, myPenColorPicker);
	}

	public Color getGridColor() {
		return myGridColorPicker.getColor();
	}
	
	public Color getPenColor() {
		return myPenColorPicker.getColor();
	}
	
}
