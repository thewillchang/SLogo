package interpreter.expression.display;

import model.MainModel;
import interpreter.expression.DisplayExpression;

public class SetPenSize extends DisplayExpression {
	public void setPenSize(MainModel mainModel, double thickness) {
		mainModel.getTurtles().get(0).getPen().setWidth(thickness);
	}
}
