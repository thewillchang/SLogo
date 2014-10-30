package viewcontroller.turtlegrid;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import viewcontroller.GUIReferenceLibrary;


/**
 * button bar shown above grid with turtles
 *
 * @author Jonathan Tseng
 *
 */
public class GridButtonBar extends HBox {

    private final static double SPEED_MIN = 0.5;
    private final static double SPEED_MAX = 5.0;

    private final static String GRID_COLOR_KEY = "GridColor";
    private final static String PEN_COLOR_KEY = "PenColor";
    private final static String SPEED_KEY = "Speed";

    private SLogoColorPicker myGridColorPicker;
    private SLogoColorPicker myPenColorPicker;
    private SLogoSlider mySpeedSlider;

    public GridButtonBar (
                          EventHandler<ActionEvent> gridColorEventHandler,
                          EventHandler<ActionEvent> penColorEventHandler,
                          ChangeListener<Number> speedSliderChangeListener) {
        setSpacing(5);
        setAlignment(Pos.CENTER);
        myGridColorPicker =
                new SLogoColorPicker(GUIReferenceLibrary.getStringTranslation(GRID_COLOR_KEY),
                                     Color.DARKBLUE, gridColorEventHandler);
        myPenColorPicker =
                new SLogoColorPicker(GUIReferenceLibrary.getStringTranslation(PEN_COLOR_KEY),
                                     Color.BLACK, penColorEventHandler);
        mySpeedSlider =
                new SLogoSlider(GUIReferenceLibrary.getStringTranslation(SPEED_KEY),
                                speedSliderChangeListener);
        mySpeedSlider.setMinMax(SPEED_MIN, SPEED_MAX);
        getChildren().addAll(myGridColorPicker, myPenColorPicker, mySpeedSlider);
    }

    public Color getGridColor () {
        return myGridColorPicker.getColor();
    }

    public Color getPenColor () {
        return myPenColorPicker.getColor();
    }

    public double getAnimationSpeed () {
        return mySpeedSlider.getValue();
    }

}
