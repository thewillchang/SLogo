package interpreter.expression;

import interpreter.SLogoResult;

import java.util.Deque;

public class TwoArgumentCommand implements SLogoExpression{

	private SLogoExpression operand1;
	private SLogoExpression operand2;
	
	@Override
	public void loadArguments(Deque<SLogoExpression> args) {
		this.operand1 = args.pop();
		this.operand2 = args.pop();
		
	}

	@Override
	public SLogoResult evaluate() {
		return null;
	}
	

}
