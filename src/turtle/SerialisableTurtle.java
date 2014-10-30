package turtle;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import javafx.scene.shape.Line;


/**
 * Serialisable Version of the Turtle class which doesn't hold the non serialisable javafx
 * components
 *
 * @author Tanaka Jimha
 *
 */
public class SerialisableTurtle implements Serializable {

    private static int ourTurtleCount;
    private int myId;
    private double translateX;
    private double translateY;
    private double rotate;
    private boolean isSelected;
    private File imageFile;
    private String penColour;
    private boolean isPenDown;
    private List<Line> lines;

    public SerialisableTurtle (Turtle turtle) {

        myId = turtle.getId();
        translateX = turtle.getTurtle().getTranslateX();
        translateY = turtle.getTurtle().getTranslateY();
        rotate = turtle.getTurtle().getRotate();
        penColour = turtle.getPen().getColor().toString();
        isPenDown = turtle.getPen().getPenDown();
        lines = turtle.getPen().getDrawnLines();

    }

    public static int getOurTurtleCount () {
        return ourTurtleCount;
    }

    public int getMyId () {
        return myId;
    }

    public double getTranslateX () {
        return translateX;
    }

    public double getTranslateY () {
        return translateY;
    }

    public double getRotate () {
        return rotate;
    }

    public boolean isSelected () {
        return isSelected;
    }

    public File getImageFile () {
        return imageFile;
    }

    public String getPenColour () {
        return penColour;
    }

    public boolean getIsPenDown () {
        return isPenDown;
    }

    public List<Line> getLines () {
        return lines;
    }
}
