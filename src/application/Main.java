package application;
	
import java.awt.Dimension;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class that initializes the Application
 * @author Jonathan Tseng
 *
 */
public class Main extends Application {
	
	public static final Dimension SIZE = new Dimension(1300, 800);
	
	
	@Override
	public void start (Stage primaryStage) {
		try {
			StartMenu menu = new StartMenu();
			menu.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		launch(args);
	}
}
