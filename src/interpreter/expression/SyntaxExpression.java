package interpreter.expression;

import java.util.Deque;
import interpreter.SLogoResult;

/**
 * superclass for SLogoExpressions that are purely syntax
 * examples include variables, constant numbers, and brackets
 * @author Jonathan Tseng
 *
 */
public abstract class SyntaxExpression implements SLogoExpression {

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
