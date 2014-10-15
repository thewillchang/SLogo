package interpreter;

import interpreter.expression.SLogoExpression;
import java.util.Deque;

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
     * @returns one SLogo results
     */
    public SLogoResult evaluateExpressionsAndMergeResults (Deque<SLogoExpression> parsedExpressions) {
        while(!parsedExpressions.isEmpty()) {
            SLogoResult result = parsedExpressions.pop().evaluate();
            myResultMerger.append(result);
        }
        
        return myResultMerger.mergeAndReturn();
    }
}
