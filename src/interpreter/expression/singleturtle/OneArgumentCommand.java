package interpreter.expression;

import interpreter.SLogoResult;

import java.util.Deque;

public class OneArgumentCommand implements SLogoExpression {
	
	private SLogoExpression operand1;

	@Override
	public void loadArguments(Deque<SLogoExpression> args) {
		this.operand1 = args.pop();	
	}

	@Override
	public SLogoResult evaluate() {
		return null;
	}

}
