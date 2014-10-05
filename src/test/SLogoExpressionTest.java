package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SLogoExpressionFactory;

import org.junit.Test;

import exceptions.SLogoParsingException;

public class SLogoExpressionTest {

	@Test
	public void testTurtleExpression() {
		SLogoExpressionFactory expressionFactory = new SLogoExpressionFactory();
		SLogoExpression forward = null;
		try {
			forward = expressionFactory.createExpression("fd 70");
		} catch (SLogoParsingException e) {

			fail("Forward Expression Test failed");
		}
		assertEquals(forward.evaluate().getValue(), 70 );
	}

	@Test
	public void testMathExpression() {
		SLogoExpressionFactory expressionFactory = new SLogoExpressionFactory();
		SLogoExpression sum = null;
		try {
			sum = expressionFactory.createExpression("sum 30 40");
		} catch (SLogoParsingException e) {
			fail("Sum Expression Test failed");
		}
		assertEquals(sum.evaluate().getValue(), 70 );
	}

	@Test
	public void testBooleanExpression() {
		SLogoExpressionFactory expressionFactory = new SLogoExpressionFactory();
		SLogoExpression bool = null;
		try {
			bool = expressionFactory.createExpression("less 3 17");
		} catch (SLogoParsingException e) {
			fail("Boolean Expression Test failed");
		}
		assertEquals(bool.evaluate().getValue(), 1 );
	}

	@Test
	public void testExceptionExpression() {
		SLogoExpressionFactory expressionFactory = new SLogoExpressionFactory();
		SLogoExpression exception;
		try {
			exception = expressionFactory.createExpression("forward forward");
		} catch (SLogoParsingException e) {
			assertTrue(e instanceof SLogoParsingException);
		}
		fail("Exception Expression Test failed");
	}
}
