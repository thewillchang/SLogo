package application;

import java.util.ArrayList;
import java.util.List;

import viewcontroller.GUIReferenceLibrary;

/**
 * form for setting pen properties
 * @author Jonathan Tseng
 *
 */
public class PenForm extends Form {

	public final static String PEN_SETTINGS_KEY = "PenSettings";
	public final static String PEN_WIDTH_KEY = "PenWidth";
	public final static String PEN_UP_KEY = "PenUp";
	public final static String PEN_DOWN_KEY = "PenDown";
	public final static String PEN_DASH_KEY = "PenDash";
	public final static String PEN_SOLID_KEY = "PenSolid";
	public final static String PEN_DOT_KEY = "PenDot";
	
	private List<String> myPenStyles;
	NumberInputFormElement myPenWidthFormElement;
	ToggleFormElement myPenUpToggleFormElement;
	DropDownFormElement myPenStyleFormElement;
	
	public PenForm() {
		super(GUIReferenceLibrary.getStringTranslation(PEN_SETTINGS_KEY));
		initializePenStyles();
		myPenWidthFormElement = 
				new NumberInputFormElement(GUIReferenceLibrary.getStringTranslation(PEN_WIDTH_KEY));
		myPenWidthFormElement.setInitialValue(4);
		addFormElement(myPenWidthFormElement);
		myPenUpToggleFormElement = new ToggleFormElement(
				GUIReferenceLibrary.getStringTranslation(PEN_UP_KEY), 
				GUIReferenceLibrary.getStringTranslation(PEN_DOWN_KEY));
		myPenUpToggleFormElement.setInitialValue(true);
		addFormElement(myPenUpToggleFormElement);
		myPenStyleFormElement = new DropDownFormElement(myPenStyles);
		myPenStyleFormElement.setInitialValue(myPenStyles.get(0));
		addFormElement(myPenStyleFormElement);
	}
	
	public PenFormResult getResult() {
		return new PenFormResult(
				myPenWidthFormElement.getSelectedValue(), 
				myPenUpToggleFormElement.getSelectedValue(), 
				myPenStyleFormElement.getSelectedValue());
	}
	
	private void initializePenStyles() {
		myPenStyles = new ArrayList<>();
		myPenStyles.add(GUIReferenceLibrary.getStringTranslation(PEN_SOLID_KEY));
		myPenStyles.add(GUIReferenceLibrary.getStringTranslation(PEN_DASH_KEY));
		myPenStyles.add(GUIReferenceLibrary.getStringTranslation(PEN_DOT_KEY));
	}

}
