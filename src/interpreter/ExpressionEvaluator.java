package interpreter;

import interpreter.expression.SLogoExpression;
import java.util.Deque;

public class ExpressionEvaluator {

    private SLogoResultMerger myResultMerger;
    public ExpressionEvaluator () {
        myResultMerger = new SLogoResultMerger();
    }
    
    public SLogoResult evaluateExpressionsAndMergeResults (Deque<SLogoExpression> parsedExpressions) {
        while(!parsedExpressions.isEmpty()) {
            SLogoResult result = parsedExpressions.pop().evaluate();
            myResultMerger.append(result);
        }
        
        return myResultMerger.mergeAndReturn();
    }
}
