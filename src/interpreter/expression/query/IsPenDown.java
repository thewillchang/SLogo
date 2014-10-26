package interpreter.expression.query;

import model.MainModel;
import interpreter.expression.TurtleQueryExpression;

public class IsPenDown extends TurtleQueryExpression {

	@Override
	protected double getValueFromModel(MainModel model) {
		return (model.getTurtles().get(0).getPen().getPenDown()) ? 1 : 0;
	}

}
