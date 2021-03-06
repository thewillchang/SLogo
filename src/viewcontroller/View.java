package viewcontroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.Deserialiser;
import model.MainModel;
import model.Serialiser;
import application.Main;
import application.MessageBox;
import application.PenForm;

/**
 * Overall main view that can has menu bar and tabbed view that can 
 * hold multiple workspaces
 * @author Jonathan Tseng
 *
 */
public class View {
	
	public final static Color BACKGROUND_COLOR = Color.DARKSLATEGREY;
	
	private Stage myStage;
	private Scene myScene;
	private BorderPane myPane;
	private TabPane myTabPane;
	
	private List<Workspace> myWorkspaces;
	private Workspace myCurrentWorkspace;
	
	private SLogoMenuBar myMenuBar;
	
	private String myLanguage;
	
	private final String Title = "Title";
	private final String Workspace = "Workspace";

	public View(Stage stage, String language) {
		myLanguage = language;
		GUIReferenceLibrary.setGUIReference(myLanguage);
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
		Workspace workspace = new Workspace(myLanguage);
		addWorkspace(workspace);
	}	
	
	public void editPenSettings() {
		PenForm penForm = new PenForm();
		penForm.show();
		penForm.setOnSubmit(event -> shit(penForm));
	}
	
	private void shit(PenForm penForm) {
		penForm.close();
		myCurrentWorkspace.getMainModel().updatePen(penForm);
	}
	
	private void showMessage(String message) {
		MessageBox messageBox = new MessageBox(message);
		messageBox.show();
	}
	
	private void noCurrentWorkspace() {
		showMessage("No current workspace");
	}
	
	private void addWorkspace(Workspace workspace) {
		myWorkspaces.add(workspace);
		myCurrentWorkspace = workspace;
		Tab tab = new Tab();
		tab.setId(Integer.toString(myWorkspaces.size() - 1));
		tab.setText(GUIReferenceLibrary.getStringTranslation(Workspace) + myWorkspaces.size());
		tab.setContent(myCurrentWorkspace.getViewController().getNode());
		myTabPane.getTabs().add(tab);
		myTabPane.getSelectionModel().select(tab);
	}
	
	private void loadSerialisedWorkspace(File file) {
		Deserialiser deserialiser = new Deserialiser();
		try {
			MainModel model = deserialiser.deserialise(new FileInputStream(file));
			Workspace workspace = new Workspace(model);
			addWorkspace(workspace);
		} catch (FileNotFoundException e) {
			showMessage("Failed to load workspace.");
		}	
	}
	
	public void saveWorkspace() {
		if (myCurrentWorkspace != null) {
			FileChooser saveChooser = new FileChooser();
			saveChooser.getExtensionFilters().add(new ExtensionFilter("Serializable", "*.ser"));
			saveChooser.setTitle("Save workspace");
			File file = saveChooser.showSaveDialog(myStage);
			if (file != null) {
				Serialiser serialiser = new Serialiser();
				serialiser.serialise(myCurrentWorkspace.getMainModel(), file);
			}
		} else {
			noCurrentWorkspace();
		}
	}
	
	public void loadWorkspace() {
		FileChooser serializableWorkspaceChooser = new FileChooser();
        serializableWorkspaceChooser.setTitle("Choose workspace to load");
        serializableWorkspaceChooser.getExtensionFilters().addAll(
        		new ExtensionFilter("Serializable", "*.ser"));
        File selectedFile = serializableWorkspaceChooser.showOpenDialog(myStage);
        if (selectedFile != null) {
        	loadSerialisedWorkspace(selectedFile);
        }
	}

	public void init() {
		myStage.show();
	}
	
	public void toggleGridLines() {
		if (myCurrentWorkspace != null) {
			myCurrentWorkspace.getViewController().toggleGridLines();
		} else {
			noCurrentWorkspace();
		}
	}
	
	public void undoClicked() {
		if (myCurrentWorkspace != null) {
			myCurrentWorkspace.getMainModel().undoClicked();
		} else {
			noCurrentWorkspace();
		}
	}
	
	public void redoClicked() {
		if (myCurrentWorkspace != null) {
			myCurrentWorkspace.getMainModel().redoClicked();
		} else {
			noCurrentWorkspace();
		}
	}
	
	public void addTurtleClicked() {
		if (myCurrentWorkspace != null) {
			myCurrentWorkspace.getMainModel().addTurtle();
		} else {
			noCurrentWorkspace();
		}
	}
	
	public void changeTurtleImages() {
        if (myCurrentWorkspace != null) {
			FileChooser turtleImageChooser = new FileChooser();
	        turtleImageChooser.setTitle("Choose Image File for Turtles");
	        turtleImageChooser.getExtensionFilters().addAll(
	        		new ExtensionFilter("JPG Images", "*.jpg"),
	        		new ExtensionFilter("PNG Images", "*.png"));
	        File selectedFile = turtleImageChooser.showOpenDialog(myStage);
	        if (selectedFile != null) {
	            myCurrentWorkspace.getMainModel().changeTurtleImages(selectedFile);
	        }
        } else {
        	noCurrentWorkspace();
        }
	}
	
	public void loadFile() {
		if (myCurrentWorkspace != null) {
			FileChooser scriptChooser = new FileChooser();
	        scriptChooser.setTitle("Load SLogo script");
	        scriptChooser.getExtensionFilters().addAll(
	        		new ExtensionFilter("SLogo files", "*.logo"));
	        File selectedFile = scriptChooser.showOpenDialog(myStage);
	        try {
				myCurrentWorkspace.getViewController().loadScript(readFile(selectedFile));
			} catch (IOException e) {
				showMessage("Failed to load file");
			}
		} else {
			noCurrentWorkspace();
		}
	}
	
	public String readFile(File file) throws IOException {
		byte[] encoded = Files.readAllBytes(file.toPath());
		return new String(encoded, StandardCharsets.UTF_8);
	}
	
	public void showHelp() {
		HelpDialogBox helpBox = new HelpDialogBox();
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
			myCurrentWorkspace = null;
		}
	}
	
	private void placeMenuBar() {
		myMenuBar = new SLogoMenuBar(this);	
		myPane.setTop(myMenuBar);
	}
	
}
