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

/**
 * Overall main view that can has menu bar and tabbed view that can 
 * hold multiple workspaces
 * @author Jonathan Tseng
 *
 */
public class View {
	
	private final static String HELP_URL = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/";
	public final static Color BACKGROUND_COLOR = Color.DARKSLATEGREY;
	
	private Stage myStage;
	private Scene myScene;
	private BorderPane myPane;
	private TabPane myTabPane;
	
	private List<Workspace> myWorkspaces;
	private Workspace myCurrentWorkspace;
	
	private SLogoMenuBar myMenuBar;
	
	private final String Title = "Title";
	private final String Workspace = "Workspace";

	public View(Stage stage) {
		GUIReferenceLibrary.setGUIReference("English");
		myWorkspaces = new ArrayList<>();
		myStage = stage;
		myPane = new BorderPane();
		myPane.setBackground(new Background(
				new BackgroundFill(BACKGROUND_COLOR, new CornerRadii(0), new Insets(0))));
		myScene = new Scene(myPane, Main.SIZE.width, Main.SIZE.height);
		myStage.setTitle(GUIReferenceLibrary.getStringTranslation(Title));
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
		tab.setText(GUIReferenceLibrary.getStringTranslation(Workspace) + myWorkspaces.size());
		tab.setContent(myCurrentWorkspace.getViewController().getNode());
		myTabPane.getTabs().add(tab);
		myTabPane.getSelectionModel().select(tab);
	}	

	public void init() {
		myStage.show();
	}
	
	public void toggleGridLines() {
		if (myCurrentWorkspace != null) {
			myCurrentWorkspace.getViewController().toggleGridLines();
		}
	}
	
	public void undoClicked() {
		if (myCurrentWorkspace != null) {
			myCurrentWorkspace.getMainModel().undoClicked();
		}
	}
	
	public void redoClicked() {
		if (myCurrentWorkspace != null) {
			myCurrentWorkspace.getMainModel().redoClicked();
		}
	}
	
	public void addTurtleClicked() {
		if (myCurrentWorkspace != null) {
			myCurrentWorkspace.getMainModel().addTurtle();
		}
	}
	
	public void showHelp() {
		HelpDialogBox helpBox = new HelpDialogBox(HELP_URL);
		helpBox.show();
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
		try {
			myCurrentWorkspace = myWorkspaces.get(Integer.parseInt(newTab.idProperty().getValue()));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	private void placeMenuBar() {
		myMenuBar = new SLogoMenuBar(this);	
		myPane.setTop(myMenuBar);
	}
	
}
