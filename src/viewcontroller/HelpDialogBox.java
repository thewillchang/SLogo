package viewcontroller;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpDialogBox {

	private static final String HTTP_KEY = "http";
	private static final String PREFIX_KEY = "urlPrefix";
	private static final String COMMANDS_KEY = "commands1";
	private String myHTTPString;
	private String myPrefixString;
	private String myCommandURLString;

	private Stage myStage;
	private String myURL;

	/**
	 * Sets up GUI Reference Mapping
	 * Constructs the URL from the prefixes and the specific command page ending
	 */
	public HelpDialogBox() {
		setUpGUIStrings();
		myURL = myHTTPString + myPrefixString + myCommandURLString;
	}

	/**
	 * Sets up the GUI Library for help reference
	 */
	private void setUpGUIStrings() {
		GUIReferenceLibrary.setHelpReference();
		myHTTPString = GUIReferenceLibrary.getURL(HTTP_KEY);
		myPrefixString = GUIReferenceLibrary.getURL(PREFIX_KEY);
		myCommandURLString = GUIReferenceLibrary.getURL(COMMANDS_KEY);
	}

	/**
	 * Display the Help Dialog Window
	 */
	public void show() {
		myStage = new Stage();
		myStage.initModality(Modality.APPLICATION_MODAL);
		BorderPane root = new BorderPane();
		Scene messageScene = new Scene(root);
		root.setCenter(makePageDisplay());
		myStage.setScene(messageScene);
		myStage.show();
	}

	/**
	 * Open up the browser and load this URL to open the page
	 * @return
	 */
	private Node makePageDisplay() {
		WebView page = new WebView();
		page.getEngine().load(myURL.toString());
		return page;
	}

}
