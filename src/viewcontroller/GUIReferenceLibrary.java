package viewcontroller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class GUIReferenceLibrary {

	private String myLanguage;
	private static Map<String, String> myGUIMap;
	private ResourceBundle myCommandReference;
	private Set<String> myKeySet;

	public GUIReferenceLibrary() {
		this("English");
	}

	public GUIReferenceLibrary(String language) {
		myLanguage = language;
		myGUIMap = new HashMap<>();
		setGUIReference();
	}
	
	public void setNewLanguage(String language) {
		myLanguage = language;
		setGUIReference();
	}

	/**
	 * Sets the Reference Language for SLogo Commands
	 * 
	 * @param language
	 *            to set to.
	 */
	private void setGUIReference() {
		myCommandReference = ResourceBundle.getBundle("resources.languages.view" + myLanguage, Locale.US);
		myKeySet = myCommandReference.keySet();
		for(String keyString : myKeySet) {
			myGUIMap.put(keyString, myCommandReference.getString(keyString));
		}
	}
	
	public static String getStringTranslation(String GUIlabel) {
		return myGUIMap.get(GUIlabel);
	}
}
