package viewcontroller;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpDialogBox {

	private static final String HTTP = "http";
	private static final String PREFIX = "urlPrefix";
	private static final String COMMANDS = "commands1";
	private String myHTTPString;
	private String myPrefixString;
	private String myCommandURLString;

	private Stage myStage;
	private String myURL;

	public HelpDialogBox() {
		setUpGUIStrings();
		myURL = myHTTPString + myPrefixString + myCommandURLString;
	}

	private void setUpGUIStrings() {
		GUIReferenceLibrary.setHelpReference();
		myHTTPString = GUIReferenceLibrary.getURL(HTTP);
		myPrefixString = GUIReferenceLibrary.getURL(PREFIX);
		myCommandURLString = GUIReferenceLibrary.getURL(COMMANDS);
	}

	public void show() {
		myStage = new Stage();
		myStage.initModality(Modality.APPLICATION_MODAL);
		BorderPane root = new BorderPane();
		Scene messageScene = new Scene(root);
		root.setCenter(makePageDisplay());
		myStage.setScene(messageScene);
		myStage.show();
	}

	private Node makePageDisplay() {
		WebView page = new WebView();
		page.getEngine().load(myURL.toString());
		return page;
	}

}
