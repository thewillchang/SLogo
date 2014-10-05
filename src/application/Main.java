package application;
	
import java.awt.Dimension;

import javafx.application.Application;
import javafx.stage.Stage;
import model.MainModel;
import viewcontroller.MainViewController;

/**
 * Main class that initializes the Application
 * @author Jonathan Tseng
 *
 */
public class Main extends Application {
	
	public static final Dimension SIZE = new Dimension(1200, 700);
	
	private MainViewController myViewController;
	private MainModel myModel;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			myViewController = new MainViewController();
			myModel = new MainModel();
			primaryStage.setTitle("SLogo - as re-envisioned by Tanaka, Will, Abhishek, and Jonathan");
			primaryStage.setScene(myViewController.getScene());
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
