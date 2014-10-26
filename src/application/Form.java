package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import viewcontroller.GUIReferenceLibrary;
import viewcontroller.SLogoFont;

public class Form {

	private final static String SUBMIT_KEY = "SubmitForm";
	
    private Stage myStage;
    private BorderPane myPane;
    private Button mySubmitButton;
    private VBox myFormBox;
    private List<FormElement> myFormElements;
    
	public Form(String title) {
		myPane = new BorderPane();
		myFormElements = new ArrayList<>();
		createTitle(title);
		createSubmitButton();
		createFormBox();
	}
	
	public void createFormBox() {
		myFormBox = new VBox();
		myFormBox.setAlignment(Pos.CENTER);
		myFormBox.setSpacing(10);
		BorderPane.setAlignment(myFormBox, Pos.CENTER);
		myPane.setCenter(myFormBox);
	}
	
	public void addFormElement(FormElement formElement) {
		myFormElements.add(formElement);
		myFormBox.getChildren().add(formElement.getNode());
	}

	public void show() {
        myStage = new Stage();
        myStage.setOnCloseRequest(event->myStage.close());
        myStage.initModality(Modality.APPLICATION_MODAL);
        Scene formScene = new Scene(myPane);
        myStage.setScene(formScene);
        myStage.show();
	}
	
	private void createTitle(String title) {
		Label titleLabel = new Label(title);
		titleLabel.setFont(new SLogoFont().createFormTitleFont());
		BorderPane.setAlignment(titleLabel, Pos.CENTER);
		BorderPane.setMargin(titleLabel, new Insets(10));
		myPane.setTop(titleLabel);
	}
	
	private void createSubmitButton() {	
		mySubmitButton = new Button(GUIReferenceLibrary.getStringTranslation(SUBMIT_KEY));
		BorderPane.setAlignment(mySubmitButton, Pos.CENTER);
		BorderPane.setMargin(mySubmitButton, new Insets(10));
		myPane.setBottom(mySubmitButton);
		mySubmitButton.setFont(new SLogoFont().createTextFont());
		mySubmitButton.setOnAction(event -> close());
	}
	
	public void close() {
		myStage.close();
	}
	
	public void setOnSubmit(EventHandler<ActionEvent> event) {
		mySubmitButton.setOnAction(event);
	}
	
}
