package interpreter.expression;

import interpreter.SLogoResult;

<<<<<<< Updated upstream
import java.util.Deque;
=======
import java.util.List;
>>>>>>> Stashed changes

public class OneArgumentCommand implements SLogoExpression {
	
	private SLogoExpression operand1;

	@Override
<<<<<<< Updated upstream
	public void loadArguments(Deque<SLogoExpression> args) {
		this.operand1 = args.pop();	
=======
	public void loadArguments(List<SLogoExpression> args) {
		this.operand1 = args.get(0);	
>>>>>>> Stashed changes
	}

	@Override
	public SLogoResult evaluate() {
		return null;
	}

}
