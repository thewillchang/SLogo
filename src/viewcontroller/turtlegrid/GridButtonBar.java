package viewcontroller.turtlegrid;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import viewcontroller.GUIReferenceLibrary;

public class GridButtonBar extends HBox {

	private final static String GRID_COLOR_KEY = "GridColor";
	private final static String PEN_COLOR_KEY = "PenColor";
	
	private SLogoColorPicker myGridColorPicker;
	private SLogoColorPicker myPenColorPicker;
	
	public GridButtonBar(EventHandler<ActionEvent> gridColorEventHandler, EventHandler<ActionEvent> penColorEventHandler) {
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		myGridColorPicker = new SLogoColorPicker(GUIReferenceLibrary.getStringTranslation(GRID_COLOR_KEY), Color.DARKBLUE, gridColorEventHandler);
		myPenColorPicker = new SLogoColorPicker(GUIReferenceLibrary.getStringTranslation(PEN_COLOR_KEY), Color.BLACK, penColorEventHandler);
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
