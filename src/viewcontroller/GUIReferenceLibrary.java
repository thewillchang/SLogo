package viewcontroller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Reference library for all strings in the GUI. We were instructed in class
 * that we would be able to make this mapping static.
 * 
 * @author Abhishek B
 *
 */
public class GUIReferenceLibrary {

	private static Map<String, String> myGUIMap;
	private static ResourceBundle myCommandReference;
	private static ResourceBundle myPathReference;
	private static ResourceBundle myHelpReference;
	private static Set<String> myKeySet;

	/**
	 * Sets the Reference Language for GUI Text Elements of the SLogo Project
	 * 
	 * @param language
	 *            to set to.
	 */
	public static void setGUIReference(String language) {
		myGUIMap = new HashMap<>();
		myCommandReference = ResourceBundle.getBundle(
				"resources.languages.view." + language, Locale.US);
		myKeySet = myCommandReference.keySet();
		for (String keyString : myKeySet) {
			myGUIMap.put(keyString, myCommandReference.getString(keyString));
		}

		setPathReference();
	}

	/**
	 * Reads the GUI map to get the string translation for any text that appears
	 * in GUI.
	 * 
	 * @param GUIlabel
	 * @return the value of the GUILabel key in the GUI Reference Map
	 */
	public static String getStringTranslation(String GUIlabel) {
		return myGUIMap.get(GUIlabel);
	}

	/**
	 * Sets the Reference for GUI Help Elements of the SLogo Project
	 */
	public static void setHelpReference() {
		myHelpReference = ResourceBundle.getBundle("resources.links.Help",
				Locale.US);
	}

	/**
	 * 
	 */
	public static void setPathReference() {
		myPathReference = ResourceBundle.getBundle("resources.links.Path",
				Locale.US);
	}

	/**
	 *
	 */
	public static String getPath(String pathKey) {
		return myPathReference.getString(pathKey);
	}

	/**
	 * Gets the URL from the Help Reference Resource Bundle
	 * 
	 * @param URLID
	 * @return URL String
	 */
	public static String getURL(String URLID) {
		return myHelpReference.getString(URLID);
	}
}
