package viewcontroller;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpDialogBox {

    public static final String PROTOCOL_PREFIX = "http://";
	
    private Stage myStage;
    private String myUrl;
	
	public HelpDialogBox(String url) {
		myUrl = (!url.startsWith(PROTOCOL_PREFIX)) ? PROTOCOL_PREFIX + url : url;   
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
        page.getEngine().load(myUrl.toString());
	    return page;	
	}
	
}
