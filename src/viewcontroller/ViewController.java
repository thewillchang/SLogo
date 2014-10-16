package viewcontroller;

import javafx.scene.Node;

/**
 * view controller interface implemented by all view controllers
 * @author Jonathan Tseng
 *
 */
public interface ViewController {

	/**
	 * returns the Node representing the view for a view controller
	 * @return
	 */
	public Node getNode();
	
}
