package interpreter.expression.conditional;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.TwoArgumentCommand;

import java.util.List;

import transitionstate.TransitionState;

/**
 * Implements the < operation on given operands
 * @author Tanaka Jimha
 * 
 *
 */

public class Greater extends TwoArgumentCommand {

	private SLogoExpression operand1;
	private SLogoExpression operand2;
	
	@Override
	public void loadArguments(List<SLogoExpression> args) {
		super.loadArguments(args);
	}

	@Override
	public SLogoResult evaluate() {
		int value = (operand1.evaluate().getValue() < operand2.evaluate().getValue()) ? 1 : 0;
		TransitionState state = new TransitionState();
		
		return new ConditionalResult(value, state);
	}
	
	
}