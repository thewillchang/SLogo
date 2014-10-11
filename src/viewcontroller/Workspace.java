package viewcontroller;

import model.MainModel;

public class Workspace {

	private MainViewController myMainViewController;
	private MainModel myMainModel;
	
	public Workspace() {
		myMainViewController = new MainViewController();
		myMainModel = new MainModel();
	}
	
	public MainViewController getViewController() {
		return myMainViewController;
	}
	
	public MainModel getMainModel() {
		return myMainModel;
	}

}
