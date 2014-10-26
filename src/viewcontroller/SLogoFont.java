package viewcontroller;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SLogoFont {

    protected static final double rootEm = javafx.scene.text.Font.getDefault().getSize();
	
	public Font createTextFont() {
		return Font.font("Garamond", FontWeight.NORMAL, rootEm * 1.2);
	}
	
	public Font createSubWindowTitleFont() {
		return Font.font("Garamond", FontWeight.BOLD, rootEm * 1.2);
	}
	
	public Font createFormTitleFont() {
		return Font.font("Garamond", FontWeight.BOLD, rootEm * 1.4);
	}
	
	public Font createLabeledContainerFont() {
		return Font.font("Garamond", FontWeight.NORMAL, rootEm * 1.4);
	}
	
	public String createButtonFontStyle() {
		return String.format("-fx-font: %f \"Garamond\";", rootEm * 1.2);
	}
	
}
