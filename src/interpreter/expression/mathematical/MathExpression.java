package interpreter.expression.mathematical;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

<<<<<<< Updated upstream:src/interpreter/expression/mathematical/MathExpression.java
import java.util.Deque;
=======

import java.util.List;
>>>>>>> Stashed changes:src/interpreter/expression/mathematical/MathExpression.java

/**
 * superclass of SLogoExpressions for Math expressions
 * @author Jonathan Tseng
 *
 */
public abstract class MathExpression implements SLogoExpression {
	
	private SLogoExpression operand1;
	private SLogoExpression operand2;
	
	@Override
<<<<<<< Updated upstream:src/interpreter/expression/mathematical/MathExpression.java
	public void loadArguments(Deque<SLogoExpression> args) {
		operand1 = args.pop();
		operand2 = args.pop();
=======
	public void loadArguments(List<SLogoExpression> args) {
		// TODO Auto-generated method stub


		operand1 = args.get(0);
		operand2 = args.get(1);
>>>>>>> Stashed changes:src/interpreter/expression/mathematical/MathExpression.java
	}

	@Override
	public SLogoResult evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
