package viewcontroller;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class SLogoMenuBar extends MenuBar {

	private final static String FILE_STRING = "File";
	private final static String HELP_STRING = "Help";
	private final static String NEW_WORKSPACE_STRING = "New workspace";
	
	private final static String EDIT_STRING = "Edit";
	private final static String REDO_STRING = "Redo";
	private final static String UNDO_STRING = "Undo";
	
	private View myParentView;
	
	private MenuItem myRedoMenuItem;
	private MenuItem myUndoMenuItem;
	
	private MenuItem myNewWorkspaceMenuItem;
	private MenuItem myHelpMenuItem;
	
	public SLogoMenuBar(View parentView) {
		super();
		this.setHover(true);
		myParentView = parentView;
		initializeFileMenu();
		initializeEditMenu();
	}
	
	private void initializeEditMenu() {
		Menu editMenu = new Menu(EDIT_STRING);
		myUndoMenuItem = new MenuItem(UNDO_STRING);
		myUndoMenuItem.setOnAction(event -> myParentView.undoClicked());	
		myRedoMenuItem = new MenuItem(REDO_STRING);
		myRedoMenuItem.setOnAction(event -> myParentView.redoClicked());
		editMenu.getItems().addAll(myUndoMenuItem, myRedoMenuItem);
		getMenus().add(editMenu);
	}
	
	private void initializeFileMenu() {
		Menu fileMenu = new Menu(FILE_STRING);
		myHelpMenuItem = new MenuItem(HELP_STRING);
		myHelpMenuItem.setOnAction(event -> myParentView.showHelp());
		myNewWorkspaceMenuItem = new MenuItem(NEW_WORKSPACE_STRING);
		myNewWorkspaceMenuItem.setOnAction(event -> myParentView.addNewWorkspace());
		fileMenu.getItems().addAll(myNewWorkspaceMenuItem, myHelpMenuItem);
		getMenus().add(fileMenu);
	}

}
