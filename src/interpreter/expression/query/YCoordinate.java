package interpreter.expression.query;

<<<<<<< HEAD
public class YCoordinate {
=======
import model.MainModel;
import interpreter.expression.TurtleQueryExpression;

/**
 * Expression to query the turtle's Y coordinate
 * @author Abhishek B
 *
 */
public class YCoordinate extends TurtleQueryExpression {

	/**
	 * Return the Y coordinate value from the model
	 */
	@Override
	protected double getValueFromModel(MainModel model) {
		return model.getTurtles().get(0).getY();
	}
>>>>>>> origin/abhishekBranch

}
