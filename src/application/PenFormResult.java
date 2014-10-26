package application;

import java.util.ArrayList;
import java.util.List;

import viewcontroller.GUIReferenceLibrary;

public class PenFormResult {
	
	private double myPenWidth;
	private boolean myPenUp;
	private List<Double> myPenDash;
	
	public PenFormResult(String penWidth, String penUp, String penStroke) {		
		if (penWidth.matches("[0-9]*")) {
			double width = Double.parseDouble(penWidth);
			if (width < 1)  {
				width = 1;
			} else if (width > 20) { 
				width = 20;
			}
			myPenWidth = width;
		} else {
			myPenWidth = 4;
		}
		myPenUp = (penUp.equals(GUIReferenceLibrary.getStringTranslation(PenForm.PEN_UP_KEY)));
		myPenDash = new ArrayList<>();
		if (penStroke.equals(GUIReferenceLibrary.getStringTranslation(PenForm.PEN_DASH_KEY))) {
			myPenDash.add(25d);
			myPenDash.add(15d);	
		} else if (penStroke.equals(GUIReferenceLibrary.getStringTranslation(PenForm.PEN_DOT_KEY))) {
			myPenDash.add(7d);
			myPenDash.add(7d);
		} else {
			//do nothing--no pen dash array for solid line
		}
		
	}
	
	public double getPenWidth() {
		return myPenWidth;
	}
	
	public boolean getPenUp() {
		return myPenUp;
	}
	
	public List<Double> getPenDash() {
		return myPenDash;
	}
	
}
