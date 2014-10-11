package application;
	
import java.awt.Dimension;

import javafx.application.Application;
import javafx.stage.Stage;
import viewcontroller.View;

/**
 * Main class that initializes the Application
 * @author Jonathan Tseng
 *
 */
public class Main extends Application {
	
	public static final Dimension SIZE = new Dimension(1200, 700);
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			View view = new View(primaryStage);
			view.init();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
