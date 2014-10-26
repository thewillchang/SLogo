package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import viewcontroller.SLogoFont;


/**
 * creates a message box in another stage to show to the user
 *
 * @author Jonathan Tseng
 *
 */
public class MessageBox {
    private static final int MESSAGE_SPACING = 10;
    private static final int MESSAGE_PADDING = 20;

    private Stage myStage;
    private String myMessage;
    private VBox myMessageBox;
    private Text myMessageText;
    private Button myOkayButton;

    /**
     * creates instance of message box class to show the associated message
     *
     * @param message
     */
    public MessageBox (String message) {
        myMessage = message;
    }

    /**
     * shows the messsage dialog
     */
    public void show () {
        myStage = new Stage();
        myStage.initModality(Modality.APPLICATION_MODAL);
        StackPane root = new StackPane();
        createMessageBox();
        root.getChildren().addAll(myMessageBox);
        Scene messageScene = new Scene(root);
        myStage.setScene(messageScene);
        myStage.show();
    }

    /**
     * creates the VBox to hold the message dialog
     */
    private void createMessageBox () {
        myMessageBox = new VBox();
        myMessageBox.setSpacing(MESSAGE_SPACING);
        myMessageBox.setPadding(new Insets(MESSAGE_PADDING));
        myMessageBox.setAlignment(Pos.CENTER);
        createMessageText();
        createOkayButton();
        myMessageBox.getChildren().addAll(myMessageText, myOkayButton);
    }

    /**
     * creates the message text for the message dialog
     */
    private void createMessageText () {
        myMessageText = new Text(myMessage);
        myMessageText.setFont(new SLogoFont().createTextFont());
    }

    /**
     * creates the okay button for the message dialog
     */
    private void createOkayButton () {
        myOkayButton = new Button("OK");
        myOkayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                myStage.close();
            }
        });
    }
}
