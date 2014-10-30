package viewcontroller;

import model.MainModel;


/**
 * Interface for every ViewController that is observing the MainModel
 * in order to update with some data
 *
 * @author Abhishek B
 * @author Jonathan Tseng
 *
 */
public interface MainModelObserver {

    /**
     * Extract the appropriate data from the model to update the view
     *
     * @param model - MainModel
     */
    public void update (MainModel model);

}
