package interpreter.expression.mathematical;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;
import interpreter.expression.TwoArgumentCommand;

import java.util.Deque;

import transitionstate.TransitionState;

public class Difference extends TwoArgumentCommand {

	private SLogoExpression operand1;
	private SLogoExpression operand2;

	@Override
	public void loadArguments(Deque<SLogoExpression> args) {
		super.loadArguments(args);
	}

	@Override
	public SLogoResult evaluate() {

		double value = (operand1.evaluate().getValue() - operand2.evaluate().getValue());
		TransitionState state = new TransitionState();

		return  new MathResult(value, state);

	}
}
