package test;

import static org.junit.Assert.*;
import java.util.Collection;
import interpreter.Parser;
import interpreter.expression.SLogoExpression;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import exceptions.SLogoParsingException;

public class ParserTester {
    @Test
    public void parseExceptionTest() {
        Parser p = new Parser();
        String input = "forward 50 50";
        try {
            Collection<SLogoExpression> expression = p.parseSLogoExpression(input);
            fail("Did not throw Exception");
        }
        catch (SLogoParsingException e) {
            assertTrue(e instanceof SLogoParsingException);
        }
    }

    @Test
    public void singleCommandParseTest() {
        Parser p = new Parser();
        String input = "forward 50";
        try {
            Collection<SLogoExpression> expressions = p.parseSLogoExpression(input);
            assertEquals(expressions.size(),1);
        }
        catch (SLogoParsingException e) {
            fail(e.toString());
        }
    }
    @Test
    public void twoCommandParseTest() {
        Parser p = new Parser();
        String input = "forward 50 forward 50";
        try {
            Collection<SLogoExpression> expressions = p.parseSLogoExpression(input);
            assertEquals(expressions.size(),2);
        }
        catch (SLogoParsingException e) {
            fail(e.toString());
        }
    }
}
