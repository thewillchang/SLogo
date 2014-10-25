package viewcontroller.turtlegrid;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import viewcontroller.SLogoFont;

public class SLogoColorPicker extends HBox {

	private ColorPicker myColorPicker;
	private Label myLabel;
	
	public SLogoColorPicker(String label, Color color, EventHandler<ActionEvent> handler) {
		createLabel(label);
		createColorPicker(color, handler);
		this.setSpacing(5);
		this.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(5), Insets.EMPTY)));
		this.setPadding(new Insets(5));
		this.setAlignment(Pos.CENTER);
	}
	
	private void createLabel(String label) {
		myLabel = new Label(label);
		myLabel.setFont(new SLogoFont().createColorPickerFont());
		this.getChildren().add(myLabel);
	}
	
	private void createColorPicker(Color color, EventHandler<ActionEvent> handler) {
		myColorPicker = new ColorPicker(color);
		myColorPicker.getStyleClass().add("button");
		this.getChildren().add(myColorPicker);
		myColorPicker.setOnAction(handler);
	}	
	
	public Color getColor() {
		return myColorPicker.getValue();
	}
	
}
