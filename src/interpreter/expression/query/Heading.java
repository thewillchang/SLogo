package interpreter.expression.query;
import model.MainModel;
import interpreter.expression.TurtleQueryExpression;
/**
 * Expression to query what angle the turtle is facing
 * @author Abhishek B
 *
 */
public class Heading extends TurtleQueryExpression {
	/**
	 * Return a double representing the angle that the
	 * currently selected turtle is facing
	 */
	@Override
	protected double getValueFromModel(MainModel model) {
		return model.getTurtles().get(0).getHeading();
	}
}