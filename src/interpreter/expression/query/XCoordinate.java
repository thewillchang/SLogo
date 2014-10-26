package interpreter.expression.query;
import model.MainModel;
import interpreter.expression.TurtleQueryExpression;
/**
 * Expression to query for the turtle's X coordinate
 * @author Abhishek B
 *
 */
public class XCoordinate extends TurtleQueryExpression {
	
	/**
	 * Return the X Coordinate value from the model
	 */
	@Override
	protected double getValueFromModel(MainModel model) {
		return model.getTurtles().get(0).getX();
	}
}