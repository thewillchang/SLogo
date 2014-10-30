package turtle;

import java.io.File;
import java.util.List;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import transitionstate.TransitionState;
import transitionstate.TransitionState.VisibleChange;
import turtle.draw.Pen;
import turtle.draw.TransitionFactory;
import viewcontroller.turtlegrid.GridViewController;


/**
 * Turtle Object. contains its own state and image view
 *
 * @author Jonathan Tseng
 *
 */
public class Turtle {
    private static int ourTurtleCount = 0;
    private int myId;
    private TurtleViewController myTurtleViewController;
    private Pen myPen;
    private boolean myIsVisible;
    private TurtleHistory myTurtleHistory;

    public Turtle () {
        myTurtleViewController = new TurtleViewController();
        myPen = new Pen(getTurtle());
        myId = ourTurtleCount;
        ourTurtleCount++;
        myTurtleHistory = new TurtleHistory();
        myIsVisible = true;
    }

    public Transition createAnimation (List<TransitionState> states) {
        ParallelTransition transition = new TransitionFactory()
        .createAnimation(this, states);
        ParallelTransition animation = new ParallelTransition();
        animation.getChildren().add(transition);
        // nesting transiton in animation so that when transition is undone
        // (using native transition.setRate(-1))
        // the on finished function won't be called
        animation.setOnFinished(event -> myTurtleHistory
                                .addHistory(new TurtleHistoryState(transition, myPen
                                                                   .getDrawnLines())));
        return animation;
    }

    public void updateVisualState (TransitionState transitionState) {
        myPen.update(transitionState.getPenChange());
        updateVisible(transitionState.getVisibleChange());
        myTurtleViewController.updateVisible(myIsVisible);
    }

    public TurtleHistoryState redo () {
        return myTurtleHistory.redo();
    }

    public TurtleHistoryState undo () {
        return myTurtleHistory.undo();
    }

    public int getId () {
        return myId;
    }

    public double getX () {
        return getTurtle().getTranslateX() - GridViewController.SIZE.width / 2;
    }

    public double getY () {
        return -1
                * (getTurtle().getTranslateY() - GridViewController.SIZE.height / 2);
    }

    public boolean getIsVisible () {
        return myIsVisible;
    }

    public boolean isSelected () {
        return myTurtleViewController.isSelected();
    }

    public double getHeading () {
        return getTurtle().getRotate();
    }

    public Pen getPen () {
        return myPen;
    }

    public Node getTurtle () {
        return myTurtleViewController.getNode();
    }

    public double getTurtleRadius () {
        return myTurtleViewController.getRadius();
    }

    public void setImage (File file) {
        myTurtleViewController.setImage(file);
    }

    private void updateVisible (VisibleChange visibleChange) {
        if (visibleChange.equals(VisibleChange.CHANGE_INVISIBLE)) {
            myIsVisible = false;
        }
        else if (visibleChange.equals(VisibleChange.CHANGE_VISIBLE)) {
            myIsVisible = true;
        }
    }
}
