// This entire file is part of my masterpiece.
// Abhishek Balakrishnan
package viewcontroller.commands;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
/**
 * Abstract class for command windows that have lists of any objects - 
 * this means ClickableLists, or lists of HBoxes.
 * @author Abhishek B
 *
 */
public abstract class CommandListWindowViewController extends CommandWindowViewController {
	protected ScrollPane myScrollPane;
	protected VBox myListVerticalBox;
	
	public CommandListWindowViewController(int width, int height) {
		super(width, height);
		myListVerticalBox = new VBox();
		myCommandWindowVerticalBox.getChildren().add(myListVerticalBox);
		myScrollPane = new ScrollPane(myCommandWindowVerticalBox);
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myPane.setCenter(myScrollPane);
	}
	/**
	 * Move the scroll bar to the bottom of the pane
	 * such that it reflects the latest content in the scroll pane.
	 */
	protected void updateScroller() {
		myScrollPane.setVvalue(myScrollPane.getVmax());
	}
}