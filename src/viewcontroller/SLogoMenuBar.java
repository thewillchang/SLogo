package viewcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Menu Bar for the SLogo interface
 * 
 * @author Jonathan Tseng
 *
 */
public class SLogoMenuBar extends MenuBar {

	private final static String GRID_KEY = "Grid";
	private final static String ADD_TURTLE_KEY = "Add";
	private final static String GRID_LINES_KEY = "Toggle";
	private final static String TURTLE_IMAGE_KEY = "TurtleImage";
	private final static String PEN_SETTINGS_KEY = "PenSettings";

	private final static String FILE_KEY = "File";
	private final static String HELP_KEY = "Help";
	private final static String NEW_WORKSPACE_KEY = "New";
	private final static String LOAD_FILE_KEY ="LoadFile";
	private final static String LOAD_WORKSPACE_KEY = "LoadWorkspace";
	private final static String SAVE_WORKSPACE_KEY = "SaveWorkspace";

	private final static String EDIT_KEY = "Edit";
	private final static String REDO_KEY = "Redo";
	private final static String UNDO_KEY = "Undo";
	

	private View myParentView;

	//Edit Menu
	private MenuItem myRedoMenuItem;
	private MenuItem myUndoMenuItem;

	//File Menu
	private MenuItem myNewWorkspaceMenuItem;
	private MenuItem myLoadWorkspaceMenuItem;
	private MenuItem mySaveWorkspaceMenuItem;
	private MenuItem myHelpMenuItem;
	private MenuItem myLoadFileMenuItem;
	
	// Grid Menu
	private MenuItem myGridLinesMenuItem;
	private MenuItem myAddTurtleMenuItem;
	private MenuItem myTurtleImageMenuItem;
	private MenuItem myPenSettingsMenuItem;

	public SLogoMenuBar(View parentView) {
		super();
		this.setHover(true);
		myParentView = parentView;
		initializeFileMenu();
		initializeEditMenu();
		initializeGridMenu();
	}

	private MenuItem createMenuItem(String name,
			EventHandler<ActionEvent> handler) {
		MenuItem item = new MenuItem(name);
		item.setOnAction(handler);
		return item;
	}

	private void initializeEditMenu() {
		Menu editMenu = new Menu(GUIReferenceLibrary.getStringTranslation(EDIT_KEY));
		myUndoMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(UNDO_KEY),
				event -> myParentView.undoClicked());
		myRedoMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(REDO_KEY),
				event -> myParentView.redoClicked());
		editMenu.getItems().addAll(myUndoMenuItem, myRedoMenuItem);
		getMenus().add(editMenu);
	}

	private void initializeFileMenu() {
		Menu fileMenu = new Menu(GUIReferenceLibrary.getStringTranslation(FILE_KEY));
		myHelpMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(HELP_KEY),
				event -> myParentView.showHelp());
		myNewWorkspaceMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(NEW_WORKSPACE_KEY),
				event -> myParentView.addNewWorkspace());
		mySaveWorkspaceMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(SAVE_WORKSPACE_KEY), 
				event -> myParentView.saveWorkspace());
		myLoadWorkspaceMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(LOAD_WORKSPACE_KEY), 
				event -> myParentView.loadWorkspace());
		myLoadFileMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(LOAD_FILE_KEY), 
				event -> myParentView.loadFile());
		fileMenu.getItems().addAll(
				myNewWorkspaceMenuItem, 
				mySaveWorkspaceMenuItem, 
				myLoadWorkspaceMenuItem, 
				myHelpMenuItem, 
				myLoadFileMenuItem);
		getMenus().add(fileMenu);
	}

	private void initializeGridMenu() {
		Menu gridMenu = new Menu(GUIReferenceLibrary.getStringTranslation(GRID_KEY));
		myAddTurtleMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(ADD_TURTLE_KEY),
				event -> myParentView.addTurtleClicked());
		myGridLinesMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(GRID_LINES_KEY),
				event -> myParentView.toggleGridLines());
		myTurtleImageMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(TURTLE_IMAGE_KEY), 
				event -> myParentView.changeTurtleImages());
		myPenSettingsMenuItem = createMenuItem(GUIReferenceLibrary.getStringTranslation(PEN_SETTINGS_KEY), 
				event -> myParentView.editPenSettings());
		gridMenu.getItems().addAll(
				myAddTurtleMenuItem, 
				myTurtleImageMenuItem, 
				myGridLinesMenuItem,
				myPenSettingsMenuItem);
		getMenus().add(gridMenu);
	}

}
