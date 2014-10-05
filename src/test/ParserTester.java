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
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void parseExceptionTest() {
        exception.expect(SLogoParsingException.class);
        Parser p = new Parser();
        String input = "forward 50 50";
        try {
            Collection<SLogoExpression> expression = p.parseSLogoExpression(input);
        }
        catch (SLogoParsingException e) {
            fail(exception.toString());
        }
    }

    @Test
    public void singleCommandParseTest() {
        exception.expect(SLogoParsingException.class);
        Parser p = new Parser();
        String input = "forward 50";
        try {
            Collection<SLogoExpression> expressions = p.parseSLogoExpression(input);
            assertEquals(expressions.size(),1);
        }
        catch (SLogoParsingException e) {
            fail(exception.toString());
        }
    }
    @Test
    public void twoCommandParseTest() {
        exception.expect(SLogoParsingException.class);
        Parser p = new Parser();
        String input = "forward 50 forward 50";
        try {
            Collection<SLogoExpression> expressions = p.parseSLogoExpression(input);
            assertEquals(expressions.size(),2);
        }
        catch (SLogoParsingException e) {
            fail(exception.toString());
        }
    }
}
