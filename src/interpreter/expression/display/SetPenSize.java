package interpreter.expression.display;

import interpreter.expression.DisplayExpression;
import model.MainModel;


/**
 * Sets size of the pen to be pixels thickness
 * Returns given pixels
 *
 * @author Abhishek B
 *
 */
public class SetPenSize extends DisplayExpression {
    public void setPenSize (MainModel mainModel, double thickness) {
        mainModel.getTurtles().get(0).getPen().setWidth(thickness);
    }
}
