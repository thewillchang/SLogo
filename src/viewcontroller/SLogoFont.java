package viewcontroller;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SLogoFont {

    protected static final double rootEm = javafx.scene.text.Font.getDefault().getSize();
	
	public Font createTextFont() {
		return Font.font("Garamond", FontWeight.NORMAL, rootEm * 1.2);
	}
	
}
