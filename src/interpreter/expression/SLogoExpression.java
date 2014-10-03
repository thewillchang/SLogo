package interpreter.expression;

import interpreter.SLogoResult;

import java.util.Collection;

public interface SLogoExpression {

	public void loadArguments(Collection<String> args);
	
	public SLogoResult evaluate();
	
}
