package viewcontroller;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Sets up preferences for styling different Font objects
 * specific to SLogo
 * @author Abhishek B
 *
 */
public class SLogoFont {

    protected static final double rootEm = javafx.scene.text.Font.getDefault().getSize();
	
	public Font createTextFont() {
		return Font.font("Garamond", FontWeight.NORMAL, rootEm * 1.2);
	}
	
	/**
	 * Font preferences for Title Text of ViewControllers
	 * @return
	 */
	public Font createSubWindowTitleFont() {
		return Font.font("Garamond", FontWeight.BOLD, rootEm * 1.2);
	}
	
	public Font createLabeledContainerFont() {
		return Font.font("Garamond", FontWeight.NORMAL, rootEm * 1.4);
	}
	
	public String createButtonFontStyle() {
		return String.format("-fx-font: %f \"Garamond\";", rootEm * 1.2);
	}
	
}
