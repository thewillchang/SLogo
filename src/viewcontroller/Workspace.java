package viewcontroller;

import model.MainModel;


/**
 * Workspace that contains a view-controller and model.
 *
 * @author Jonathan Tseng
 *
 */
public class Workspace {

    private MainViewController myMainViewController;
    private MainModel myMainModel;

    public Workspace (String language) {
        this(new MainModel(language));
    }

    public Workspace (MainModel model) {
        myMainModel = model;
        myMainViewController = new MainViewController(myMainModel);
        myMainModel.addTurtle();
    }

    public MainViewController getViewController () {
        return myMainViewController;
    }

    public MainModel getMainModel () {
        return myMainModel;
    }

}
