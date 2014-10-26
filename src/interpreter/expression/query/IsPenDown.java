package interpreter.expression.query;
import model.MainModel;
import interpreter.expression.TurtleQueryExpression;
/**
 * Expression to query if the pen is down
 * @author Abhishek B
 *
 */
public class IsPenDown extends TurtleQueryExpression {
	/**
	 * Return a double representing whether the pen is up or down
	 * 1 if the pen is down, 0 if the pen is up
	 */
	@Override
	protected double getValueFromModel(MainModel model) {
		return (model.getTurtles().get(0).getPen().getPenDown()) ? 1 : 0;
	}
}