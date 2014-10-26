package viewcontroller.turtlegrid;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Slider;

/**
 * slider element for SLogo
 * @author Jonathan Tseng
 *
 */
public class SLogoSlider extends SLogoLabeledContainer {

	private Slider mySlider;
	
	public SLogoSlider(String label, ChangeListener<Number> listener) {
		super(label);
        mySlider = new Slider();
        mySlider.valueProperty().addListener(listener);
        addNode(mySlider);
	}
	
	public void setMinMax(double min, double max) {
        mySlider.setMin(min);
        mySlider.setMax(max);
        mySlider.setValue((min + max) / 2.0);
	}

	public double getValue() {
		return mySlider.getValue();
	}
	
}
