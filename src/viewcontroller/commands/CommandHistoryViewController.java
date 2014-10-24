package viewcontroller.commands;

import java.util.List;

import model.CommandHistoryModel;
import model.MainModel;
import javafx.scene.Node;
import viewcontroller.GUIReferenceLibrary;
import viewcontroller.MainModelObserver;
import viewcontroller.SLogoFont;

/**
 * View controller for window of history of commands
 * 
 * @author Abhishek B
 *
 */

public class CommandHistoryViewController extends CommandClickableListWindowViewController implements MainModelObserver {
	
	private final String History = "History";
	
	public CommandHistoryViewController(CommandWindowContainerViewController commandWindowContainer) {
		super();
		myCommandWindowContainer = commandWindowContainer;
		myTitleLabel.setText(commandMapValue + GUIReferenceLibrary.getStringTranslation(History));
		myTitleLabel.setFont(new SLogoFont().createTextFont());
	}

	@Override
	public Node getNode() {
		return myPane;
	}

	@Override
	public void update(MainModel model) {
		myListVerticalBox.getChildren().clear();
		CommandHistoryModel historyModel = model.getCommandHistory();
		List<String> commandHistory = historyModel.getHistory();
		for (String command : commandHistory) {
			addCommand(command);
		}	
	}

	@Override
	protected void applyTranslations() {
		
	}
}
