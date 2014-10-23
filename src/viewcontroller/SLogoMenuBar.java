package viewcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Menu Bar for the SLogo interface
 * @author Jonathan Tseng
 *
 */
public class SLogoMenuBar extends MenuBar {

	private final static String GRID_STRING = "Grid";
	private final static String ADD_TURTLE_STRING = "Add turtle";
	private final static String GRID_LINES_STRING = "Toggle grid lines";
	
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
	
	private MenuItem myGridLinesMenuItem;
	private MenuItem myAddTurtleMenuItem;

	
	
	public SLogoMenuBar(View parentView) {
		super();
		this.setHover(true);
		myParentView = parentView;
		initializeFileMenu();
		initializeEditMenu();
		initializeGridMenu();
	}
	
	private MenuItem createMenuItem(String name, EventHandler<ActionEvent> handler) {
		MenuItem item = new MenuItem(name);
		item.setOnAction(handler);
		return item;
	}
	
	private void initializeEditMenu() {
		Menu editMenu = new Menu(EDIT_STRING);
		myUndoMenuItem = createMenuItem(UNDO_STRING, event->myParentView.undoClicked());
		myRedoMenuItem = createMenuItem(REDO_STRING, event->myParentView.redoClicked());
		editMenu.getItems().addAll(myUndoMenuItem, myRedoMenuItem);
		getMenus().add(editMenu);
	}
	
	private void initializeFileMenu() {
		Menu fileMenu = new Menu(FILE_STRING);
		myHelpMenuItem = createMenuItem(HELP_STRING, event->myParentView.showHelp());
		myNewWorkspaceMenuItem = createMenuItem(NEW_WORKSPACE_STRING, event->myParentView.addNewWorkspace());
		fileMenu.getItems().addAll(myNewWorkspaceMenuItem, myHelpMenuItem);
		getMenus().add(fileMenu);
	}
	
	private void initializeGridMenu() {
		Menu gridMenu = new Menu(GRID_STRING);
		myAddTurtleMenuItem = createMenuItem(ADD_TURTLE_STRING, event->myParentView.addTurtleClicked());
		myGridLinesMenuItem = createMenuItem(GRID_LINES_STRING, event->myParentView.toggleGridLines());
		gridMenu.getItems().addAll(myAddTurtleMenuItem, myGridLinesMenuItem);
		getMenus().add(gridMenu);
	}

}
