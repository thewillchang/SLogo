package viewcontroller;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import model.MainModel;
import viewcontroller.commands.CommandWindowContainerViewController;
import viewcontroller.turtlegrid.TurtleWindowViewController;


/**
 * view controller for main view--contains rest of views and places them
 * accordingly
 *
 * @author Jonathan Tseng
 *
 */
public class MainViewController implements ViewController, MainModelObserver {

    private final static Insets GRID_MARGIN = new Insets(15);

    private MainModel myMainModel;
    private BorderPane myPane;
    private TurtleWindowViewController myTurtleWindow;
    private CommandWindowContainerViewController myCommandWindow;
    private List<MainModelObserver> myChildObservers;

    public MainViewController (MainModel mainModel) {
        myMainModel = mainModel;
        myChildObservers = new ArrayList<>();
        mainModel.attachObserver(this);
        myPane = new BorderPane();
        placeTurtleWindowView();
        placeCommandWindowView();
    }

    public void passSLogoCommand (String command) {
        myMainModel.interpretSLogoCommand(command);
    }

    public void passSLogoCommand (String commandKey, String operands) {
        myMainModel.interpretSLogoCommand(commandKey, operands);
    }

    public void loadScript (String script) {
        myCommandWindow.loadScript(script);
    }

    public void toggleGridLines () {
        myTurtleWindow.toggleGridLines();
    }

    public void gridColorChanged (Color color) {
        myMainModel.setBackgroundColor(color);
    }

    public void penColorChanged (Color color) {
        myMainModel.updatePenColor(color);
    }

    public void animationSpeedChanged (double speed) {
        myMainModel.updateAnimationSpeed(speed);
    }

    /**
     * Sets up left side of the screen - the Turtle Window/Grid related
     * animations
     */
    private void placeTurtleWindowView () {
        myTurtleWindow = new TurtleWindowViewController(this);
        BorderPane.setAlignment(myTurtleWindow.getNode(), Pos.CENTER);
        BorderPane.setMargin(myTurtleWindow.getNode(), GRID_MARGIN);
        myPane.setLeft(myTurtleWindow.getNode());
        myChildObservers.add(myTurtleWindow);
    }

    /**
     * Sets up right side of the screen - the Command Window related panes
     */
    private void placeCommandWindowView () {
        myCommandWindow = new CommandWindowContainerViewController(this);
        BorderPane.setAlignment(myTurtleWindow.getNode(), Pos.CENTER);
        BorderPane.setMargin(myTurtleWindow.getNode(), GRID_MARGIN);
        myPane.setRight(myCommandWindow.getNode());
        myChildObservers.add(myCommandWindow);
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
