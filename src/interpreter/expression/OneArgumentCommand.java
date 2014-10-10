package interpreter.expression;

import interpreter.SLogoResult;

import java.util.List;

public class OneArgumentCommand implements SLogoExpression {
	
	private SLogoExpression operand1;

	@Override
	public void loadArguments(List<SLogoExpression> args) {
		this.operand1 = args.get(0);	
	}

	@Override
	public SLogoResult evaluate() {
		return null;
	}

}
