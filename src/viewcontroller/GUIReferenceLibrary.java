package viewcontroller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * 
 * @author Abhishek B
 *
 */
public class GUIReferenceLibrary {

	private static Map<String, String> myGUIMap;
	private static ResourceBundle myCommandReference;
	private static ResourceBundle myHelpReference;
	private static Set<String> myKeySet;

	/**
	 * Sets the Reference Language for GUI Elements of the SLogo Project
	 * 
	 * @param language
	 *            to set to.
	 */
	public static void setGUIReference(String language) {
		myGUIMap = new HashMap<>();
		myCommandReference = ResourceBundle.getBundle("resources.languages.view." + language, Locale.US);
		myKeySet = myCommandReference.keySet();
		for(String keyString : myKeySet) {
			myGUIMap.put(keyString, myCommandReference.getString(keyString));
		}
	}
	
	public static String getStringTranslation(String GUIlabel) {
		return myGUIMap.get(GUIlabel);
	}
	
	public static void setHelpReference() {
		myHelpReference = ResourceBundle.getBundle("resources.help.Help", Locale.US);
	}
	
	public static String getURL(String URLID) {
		return myHelpReference.getString(URLID);
	}
}
