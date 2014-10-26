package interpreter.expression.query;

import model.MainModel;
import interpreter.expression.TurtleQueryExpression;

public class YCoordinate extends TurtleQueryExpression {

	@Override
	protected double getValueFromModel(MainModel model) {
		return model.getTurtles().get(0).getTurtle().getTranslateY();
	}

}
