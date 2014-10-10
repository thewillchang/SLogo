package interpreter.expression;

import interpreter.SLogoResult;

import java.util.List;

/**
 * superclass for SLogoExpressions that are purely syntax
 * examples include variables, constant numbers, and brackets
 * @author Jonathan Tseng
 *
 */
public abstract class SyntaxExpression implements SLogoExpression {

	@Override
	public void loadArguments(List<SLogoExpression> args) {
		// TODO Auto-generated method stub

	}

	@Override
	public SLogoResult evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
