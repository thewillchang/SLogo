package interpreter.expression.query;
import model.MainModel;
import interpreter.expression.TurtleQueryExpression;
/**
 * Expression to query if the turtle is visible
 * @author Abhishek B
 *
 */
public class IsShowing extends TurtleQueryExpression {
	/**
	 * Return a double representing whether the turtle is
	 * visible or not - 1 if the turtle is visible,
	 * 0 if the turtle is invisible
	 */
	@Override
	protected double getValueFromModel(MainModel model) {
		return (model.getTurtles().get(0).getIsVisible()) ? 1 : 0;
	}
}