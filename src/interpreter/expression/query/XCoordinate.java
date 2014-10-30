package interpreter.expression.query;

import interpreter.expression.TurtleQueryExpression;
import model.MainModel;


/**
 * Expression to query for the turtle's X coordinate
 *
 * @author Abhishek B
 *
 */
public class XCoordinate extends TurtleQueryExpression {

    /**
     * Return the X Coordinate value from the model
     */
    @Override
    protected double getValueFromModel (MainModel model) {
        return model.getTurtles().get(0).getX();
    }
}
