package interpreter.expression;

import interpreter.SLogoResult;

import java.util.List;

public class TwoArgumentCommand implements SLogoExpression{

	private SLogoExpression operand1;
	private SLogoExpression operand2;
	
	@Override
	public void loadArguments(List<SLogoExpression> args) {
		this.operand1 = args.get(0);
		this.operand2 = args.get(1);
		
	}

	@Override
	public SLogoResult evaluate() {
		return null;
	}
	

}
