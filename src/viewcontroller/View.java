package viewcontroller;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import application.Main;

public class View {
	
	private final static String HELP_URL = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/";
	
	private Stage myStage;
	private Scene myScene;
	private BorderPane myPane;
	private TabPane myTabPane;
	
	private List<Workspace> myWorkspaces;
	private Workspace myCurrentWorkspace;
	
	private SLogoMenuBar myMenuBar;

	public View(Stage stage) {
		myWorkspaces = new ArrayList<>();
		myStage = stage;
		myPane = new BorderPane();
		myPane.setBackground(new Background(
				new BackgroundFill(Color.DARKSLATEGRAY, new CornerRadii(0), new Insets(0))));
		myScene = new Scene(myPane, Main.SIZE.width, Main.SIZE.height);
		myStage.setTitle("SLogo - as re-envisioned by Tanaka, Will, Abhishek, and Jonathan");
		myStage.setScene(myScene);
		initializeTabPane();
		addNewWorkspace();
		placeMenuBar();
	}
	
	public void addNewWorkspace() {
		Workspace workspace = new Workspace();
		myWorkspaces.add(workspace);
		myCurrentWorkspace = workspace;
		Tab tab = new Tab();
		tab.setId(Integer.toString(myWorkspaces.size() - 1));
		tab.setText("Workspace " + myWorkspaces.size());
		tab.setContent(myCurrentWorkspace.getViewController().getNode());
		myTabPane.getTabs().add(tab);
	}	

	public void init() {
		myStage.show();
	}
	
	public void undoClicked() {
		if (myCurrentWorkspace == null) System.out.println("shit");
		else myCurrentWorkspace.getViewController().undoClicked();
	}
	
	public void redoClicked() {
		myCurrentWorkspace.getViewController().redoClicked();
	}
	
	public void showHelp() {
		HelpDialogBox helpBox = new HelpDialogBox(HELP_URL);
		helpBox.show();
		System.out.println("here");
	}
	
	public Scene getScene() {
		return myScene;
	}
	
	private void initializeTabPane() {
		myTabPane = new TabPane();
		myPane.setCenter(myTabPane);
		myTabPane.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldTab, newTab) -> tabChanged(observable, oldTab, newTab));
	}
	
	private void tabChanged(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
		myCurrentWorkspace = myWorkspaces.get(Integer.parseInt(newTab.idProperty().getValue()));
	}
	
	private void placeMenuBar() {
		myMenuBar = new SLogoMenuBar(this);	
		myPane.setTop(myMenuBar);
	}
	
}