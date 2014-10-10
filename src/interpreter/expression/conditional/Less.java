package interpreter.expression.conditional;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

import java.util.List;

import transitionstate.TransitionState;

/**
 * Implements the < operation on given operands
 * @author Tanaka Jimha
 * 
 *
 */

public class Less extends ConditionalExpression {

	private SLogoExpression operand1;
	private SLogoExpression operand2;
	
	@Override
	public void loadArguments(List<SLogoExpression> args) {
		operand1 = args.get(0);
		operand2 = args.get(1);
	}

	@Override
	public SLogoResult evaluate() {
		int value = (operand1.evaluate().getValue() < operand2.evaluate().getValue()) ? 1 : 0;
		TransitionState state = new TransitionState();
		
		return new ConditionalResult(value, state);
	}
	
	
}
