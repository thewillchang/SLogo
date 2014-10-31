// This entire file is part of my masterpiece.
// William Chang
package test;

import static org.junit.Assert.assertTrue;
import interpreter.Interpreter;
import interpreter.result.SLogoResult;
import model.MainModel;
import org.junit.Test;

/**
 * 
 * @author Will Chang
 *
 */

public class MathExpressionTester {

    @Test
    public void sumTest() {
        Interpreter interpreter = new Interpreter(new MainModel("English"));
        SLogoResult result = interpreter.interpret("sum 1 1");
        SLogoResult result1 = interpreter.interpret("sum 1 0");
        SLogoResult result2 = interpreter.interpret("sum 2 1");
        SLogoResult result3 = interpreter.interpret("sum -1 1");
        SLogoResult result4 = interpreter.interpret("sum 1 -2");
        assertTrue(result.getValue() == 2
                &&result1.getValue() == 1
                &&result2.getValue() == 3
                &&result3.getValue() == 0
                &&result4.getValue() == -1);
    }

    @Test
    public void arcTanTest() {
        Interpreter interpreter = new Interpreter(new MainModel("English"));
        SLogoResult result = interpreter.interpret("pow 2 3");
        SLogoResult result1 = interpreter.interpret("pow 2 -2");
        assertTrue(result.getValue() == 8
                &&result1.getValue() == 0.25);
    }
}
