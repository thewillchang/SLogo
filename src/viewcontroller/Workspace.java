package viewcontroller;

import model.MainModel;

/**
 * Workspace that contains a view-controller and model.
 * @author Jonathan Tseng
 *
 */
public class Workspace {

	private MainViewController myMainViewController;
	private MainModel myMainModel;
	
	public Workspace() {
		myMainModel = new MainModel();
		myMainViewController = new MainViewController(myMainModel);
	}
	
	public MainViewController getViewController() {
		return myMainViewController;
	}
	
	public MainModel getMainModel() {
		return myMainModel;
	}

}
