package interpreter.expression;

import java.util.Deque;
import interpreter.SLogoResult;

/**
 * superclass of SLogoExpressions for Math expressions
 * @author Jonathan Tseng
 *
 */
public abstract class MathExpression implements SLogoExpression {

	@Override
	public void loadArguments(Deque<SLogoExpression> args) {
		// TODO Auto-generated method stub

	}

	@Override
	public SLogoResult evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
