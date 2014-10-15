package interpreter.expression.math;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

import java.util.Deque;

/**
 * superclass of SLogoExpressions for Math expressions
 * @author Jonathan Tseng
 *
 */
public abstract class MathExpression implements SLogoExpression {
	
	private SLogoExpression operand1;
	private SLogoExpression operand2;
	
	@Override
	public void loadArguments(Deque<SLogoExpression> args) {
		operand1 = args.pop();
		operand2 = args.pop();
	}

	@Override
	public SLogoResult evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
