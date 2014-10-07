package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import interpreter.expression.ConditionalExpression;
import interpreter.expression.MathExpression;
import interpreter.expression.SLogoExpression;
import interpreter.expression.SLogoExpressionFactory;
import interpreter.expression.SyntaxExpression;
//import interpreter.expression.TurtleCommandExpression;
import interpreter.expression.TurtleQueryExpression;

import org.junit.Test;

/**
 * JUnit test class for SLogogExpressionFactory
 * @author Jonathan Tseng
 *
 */
public class SLogoExpressionFactoryTest {
	
	@Test
	public void testUnimplementedMethodException() {
		SLogoExpressionFactory factory = new SLogoExpressionFactory();
		try {
			factory.createExpression("helloworld");
			fail("Should throw unimplemented method exception");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("unimplemented method"));
		}
	}
	
	/*
	@Test
	public void testCreateSLogoTurtleCommandExpression() {
		SLogoExpressionFactory factory = new SLogoExpressionFactory();
		try {
			SLogoExpression expression = factory.createExpression("fd");
			assertTrue(expression instanceof TurtleCommandExpression);
		} catch (Exception e) {
			fail("should not have thrown exception");
		}
	}*/
	
	@Test
	public void testCreateSLogoMathExpression() {
		SLogoExpressionFactory factory = new SLogoExpressionFactory();
		try {
			SLogoExpression expression = factory.createExpression("cos");
			assertTrue(expression instanceof MathExpression);
		} catch (Exception e) {
			fail("should not have thrown exception");
		}
	}
	
	@Test
	public void testCreateSLogoTurtleQueryExpression() {
		SLogoExpressionFactory factory = new SLogoExpressionFactory();
		try {
			SLogoExpression expression = factory.createExpression("xcor");
			assertTrue(expression instanceof TurtleQueryExpression);
		} catch (Exception e) {
			fail("should not have thrown exception");
		}
	}
	
	@Test
	public void testCreateSLogoConditionalExpression() {
		SLogoExpressionFactory factory = new SLogoExpressionFactory();
		try {
			SLogoExpression expression = factory.createExpression("equal?");
			assertTrue(expression instanceof ConditionalExpression);
		} catch (Exception e) {
			fail("should not have thrown exception");
		}
	}

	@Test
	public void testCreateSLogoSyntaxExpression() {
		SLogoExpressionFactory factory = new SLogoExpressionFactory();
		try {
			SLogoExpression expression = factory.createExpression("[");
			assertTrue(expression instanceof SyntaxExpression);
		} catch (Exception e) {
			fail("should not have thrown exception");
		}
	}

}
