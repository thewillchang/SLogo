package interpreter.expression.query;

import model.MainModel;
import interpreter.expression.TurtleQueryExpression;

/**
 * 
 * @author Abhishek B
 *
 */
public class Heading extends TurtleQueryExpression {

	@Override
	protected double getValueFromModel(MainModel model) {
		return model.getTurtles().get(0).getTurtle().getTranslateX();
	}

}
