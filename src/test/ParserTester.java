package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import interpreter.CommandReferenceLibrary;
import interpreter.Parser;
import interpreter.expression.SLogoExpression;
import java.util.Collection;
import org.junit.Test;
import exceptions.SLogoParsingException;

public class ParserTester {
	
    @Test
    public void parseExceptionTest() {
        Parser p = new Parser(new CommandReferenceLibrary());
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
        Parser p = new Parser(new CommandReferenceLibrary());
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
        Parser p = new Parser(new CommandReferenceLibrary());
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
