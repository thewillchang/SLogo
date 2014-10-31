package interpreter;

import interpreter.expression.SLogoExpression;
import interpreter.result.SLogoResult;
import java.util.Deque;
import exceptions.SLogoParsingException;

/**
 * Evaluates given Expressions and merges results as needed
 * @author Will Chang
 *
 */

public class ExpressionEvaluator {

    private SLogoResultMerger myResultMerger;
    
    /**
     * Initializes the Merger
     */
    public ExpressionEvaluator () {
        myResultMerger = new SLogoResultMerger();
    }
    
    /**
     * Evaluates all expressions and Merges the Results
     * @param parsedExpressions
     * @throws SLogoParsingException 
     * @returns one SLogo results
     */
    public SLogoResult evaluateExpressionsAndMerge (Deque<SLogoExpression> parsedExpressions) 
            throws SLogoParsingException {
        while (!parsedExpressions.isEmpty()) {
            SLogoResult result = parsedExpressions.pop().evaluate();
            myResultMerger.append(result);
        }
        
        return myResultMerger.mergeAndReturn();
    }
}
