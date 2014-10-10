package interpreter.expression.mathematical;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

import java.util.List;

/**
 * superclass of SLogoExpressions for Math expressions
 * @author Jonathan Tseng
 *
 */
public abstract class MathExpression implements SLogoExpression {
	
	private SLogoExpression operand1;
	private SLogoExpression operand2;
	
	@Override
	public void loadArguments(List<SLogoExpression> args) {
		operand1 = args.get(0);
		operand2 = args.get(1);
	}

	@Override
	public SLogoResult evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
