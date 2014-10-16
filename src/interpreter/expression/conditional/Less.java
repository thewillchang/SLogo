package interpreter.expression.conditional;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.TwoArgumentCommand;

<<<<<<< Updated upstream
import java.util.Deque;
=======
import java.util.List;
>>>>>>> Stashed changes

import transitionstate.TransitionState;

/**
 * Implements the < operation on given operands
 * @author Tanaka Jimha
 * 
 *
 */

public class Less extends TwoArgumentCommand {

	private SLogoExpression operand1;
	private SLogoExpression operand2;
	
	@Override
<<<<<<< Updated upstream
	public void loadArguments(Deque<SLogoExpression> args) {
=======
	public void loadArguments(List<SLogoExpression> args) {
>>>>>>> Stashed changes
		super.loadArguments(args);
	}

	@Override
	public SLogoResult evaluate() {
		int value = (operand1.evaluate().getValue() < operand2.evaluate().getValue()) ? 1 : 0;
		TransitionState state = new TransitionState();
		
		return new ConditionalResult(value, state);
	}
	
	
}
