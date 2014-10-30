package viewcontroller.turtlegrid;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;


/**
 * Grid Lines for the turtle grid
 *
 * @author Jonathan Tseng
 *
 */
public class GridLines extends Group {

    private static double myLineWidth = 1.5;
    private static Color myLineColor = Color.GRAY;
    private int myNumRows;
    private int myNumColumns;
    private double myWidth;
    private double myHeight;

    public GridLines (double height, double width) {
        myWidth = width;
        myHeight = height;
        setNumRowsAndNumColumns();
        createGridLines();
        styleLines();
    }

    public void changeSize (double height, double width) {
        myWidth = width;
        myHeight = height;
        getChildren().clear();
        createGridLines();
        styleLines();
    }

    private void setNumRowsAndNumColumns () {
        myNumColumns = 30;
        myNumRows = (int) (myHeight / myWidth * myNumColumns);
    }

    private void styleLines () {
        for (Node child : getChildren()) {
            Line line = (Line) child;
            line.setFill(myLineColor);
            line.setStroke(myLineColor);
            line.setStrokeWidth(myLineWidth);
            line.setStrokeLineCap(StrokeLineCap.SQUARE);
        }
    }

    private void createGridLines () {
        createRows();
        createColumns();
    }

    private void createRows () {
        for (int i = 0; i <= myNumRows; i++) {
            Line line = createRow();
            line.setTranslateY(myHeight * i / myNumRows);
            getChildren().add(line);
        }
    }

    private Line createRow () {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(0);
        line.setEndX(myWidth);
        line.setEndY(0);
        return line;
    }

    private void createColumns () {
        for (int i = 0; i <= myNumColumns; i++) {
            Line line = createColumn();
            line.setTranslateX(myWidth * i / myNumColumns);
            getChildren().add(line);
        }
    }

    private Line createColumn () {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(0);
        line.setEndX(0);
        line.setEndY(myHeight);
        return line;
    }

    public void toggle () {
        setVisible(!visibleProperty().get());
    }

}
