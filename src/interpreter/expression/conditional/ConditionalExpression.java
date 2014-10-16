package interpreter.expression.conditional;

import interpreter.SLogoResult;
import interpreter.expression.SLogoExpression;

<<<<<<< Updated upstream:src/interpreter/expression/conditional/ConditionalExpression.java
import java.util.Deque;
=======

import java.util.List;
>>>>>>> Stashed changes:src/interpreter/expression/conditional/ConditionalExpression.java

/**
 * superclass of SLogoExpressions for conditionals
 * @author Jonathan Tseng
 *
 */
public abstract class ConditionalExpression implements SLogoExpression {
	

	@Override
	public void loadArguments(Deque<SLogoExpression> args) {
		// TODO Auto-generated method stub

	}

	@Override
	public SLogoResult evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
