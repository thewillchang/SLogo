package interpreter.expression.conditional;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

import java.util.Deque;

/**
 * superclass of SLogoExpressions for conditionals
 * @author Jonathan Tseng
 *
 */
public abstract class ConditionalExpression implements SLogoExpression {
	

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
