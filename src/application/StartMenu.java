package application;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import viewcontroller.SLogoFont;
import viewcontroller.View;

public class StartMenu {

	private final static String LANGUAGES_KEY = "Languages";
	private final static String FILE_NAME = "resources.languages.view.SupportedLanguages";	
	private final static String TITLE = "SLOGO: Choose a language";
	private final static String OKAY = "OK";
	
	private Stage myStage;
    private Label myTitleLabel;
    private BorderPane myPane;
    private Button myOkayButton;
    private ComboBox<String> myLanguageChooser;
	
	public StartMenu() {
		myStage = new Stage();
        myPane = new BorderPane();
        createTitleBox();
        createLanguageChooser();
        createOkayButton();
        Scene scene = new Scene(myPane);
		myStage.setScene(scene);
	}
	
	public void show() {
        myStage.show();
	}
	
    private void createTitleBox() {
        myTitleLabel = new Label(TITLE);
    	BorderPane.setAlignment(myTitleLabel, Pos.CENTER);
    	BorderPane.setMargin(myTitleLabel, new Insets(20));
        myTitleLabel.setFont(new SLogoFont().createSubWindowTitleFont());
        myPane.setTop(myTitleLabel);
    }
    
    private void createLanguageChooser() {
    	ResourceBundle res = ResourceBundle.getBundle(FILE_NAME);
    	myLanguageChooser = new ComboBox<>();
    	BorderPane.setAlignment(myLanguageChooser, Pos.CENTER);
    	myLanguageChooser.getItems().addAll(res.getString(LANGUAGES_KEY).split("\\|"));
    	myLanguageChooser.setValue(myLanguageChooser.getItems().get(0));
    	myLanguageChooser.setStyle(new SLogoFont().createButtonFontStyle());
    	myPane.setCenter(myLanguageChooser);
    }

    private void createOkayButton() {
    	myOkayButton = new Button(OKAY);
    	BorderPane.setAlignment(myOkayButton, Pos.CENTER);
    	BorderPane.setMargin(myOkayButton, new Insets(20));
    	myOkayButton.setFont(new SLogoFont().createTextFont());
    	myPane.setBottom(myOkayButton);
    	myOkayButton.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				myStage.close();
				View view = new View(myStage, myLanguageChooser.getValue());
				view.init();
			}
		});
    }
    
}
