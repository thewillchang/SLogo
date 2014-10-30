package viewcontroller.turtlegrid;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import model.MainModel;
import viewcontroller.MainModelObserver;
import viewcontroller.MainViewController;
import viewcontroller.ViewController;
import application.Main;


/**
 * View Controller for Grid View (Where drawing and turtle is located on)
 *
 * @author Jonathan Tseng
 *
 */
public class TurtleWindowViewController implements ViewController,
MainModelObserver {

    public static final Dimension SIZE = new Dimension(
                                                       Main.SIZE.width / 2 * 9 / 10,
                                                       Main.SIZE.height * 9 / 10);

    private MainViewController myParent;
    private BorderPane myPane;
    private TurtleStatusViewController myStatusView;
    private GridViewController myGridView;
    private List<MainModelObserver> myChildObservers;
    private GridButtonBar myGridButtonBar;

    public TurtleWindowViewController (MainViewController parent) {
        myParent = parent;
        myChildObservers = new ArrayList<>();
        myPane = new BorderPane();
        myPane.setPrefSize(SIZE.width, SIZE.height);

        myGridButtonBar = new GridButtonBar(
                                            gridEvent -> gridColorChanged(),
                                            penEvent -> penColorChanged(),
                                            new ChangeListener<Number>() {
                                                @Override
                                                public void changed (
                                                                     ObservableValue<? extends Number> observable,
                                                                     Number oldValue,
                                                                     Number newValue) {
                                                    animationSpeedChanged(newValue.doubleValue());
                                                }
                                            });
        myPane.setTop(myGridButtonBar);
        animationSpeedChanged(myGridButtonBar.getAnimationSpeed());

        placeStatusView();
        placeGridView();
    }

    public void passSLogoCommand (String commandKey, String operands) {
        myParent.passSLogoCommand(commandKey, operands);
    }

    private void animationSpeedChanged (double newSpeed) {
        myParent.animationSpeedChanged(newSpeed);
    }

    private void gridColorChanged () {
        myParent.gridColorChanged(myGridButtonBar.getGridColor());
    }

    private void penColorChanged () {
        myParent.penColorChanged(myGridButtonBar.getPenColor());
    }

    private void placeStatusView () {
        myStatusView = new TurtleStatusViewController(SIZE.width * 9 / 10,
                                                      SIZE.height * 1 / 10);
        BorderPane.setAlignment(myStatusView.getNode(), Pos.CENTER);
    }

    private void placeGridView () {
        myGridView = new GridViewController(this);
        myPane.setCenter(myGridView.getNode());
        myChildObservers.add(myGridView);
    }

    public void toggleGridLines () {
        myGridView.toggleGridLines();
    }

    @Override
    public Node getNode () {
        return myPane;
    }

    @Override
    public void update (MainModel model) {
        for (MainModelObserver child : myChildObservers) {
            child.update(model);
        }
    }

    @Override
    public void applyTranslations () {
    }

}
