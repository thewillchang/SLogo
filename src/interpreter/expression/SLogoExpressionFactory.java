package interpreter.expression;

import exceptions.SLogoParsingException;

/**
 * factory for creating an SLogoExpression for a given string
 * throws exception for unimplemented or nonexistant method names
 * @author Jonathan Tseng
 *
 */
public class SLogoExpressionFactory {

	/**
	 * creates an SLogoExpression based on given command string
	 * throws parsing exception if no command exists for given string
	 * @param command
	 * @return
	 * @throws ParsingException
	 */
	public SLogoExpression createExpression(String command) throws SLogoParsingException {
		return null;
	}

}
