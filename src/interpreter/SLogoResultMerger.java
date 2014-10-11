package interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class SLogoResultMerger {

    private Deque<SLogoResult> resultsToMerge;
    
    public SLogoResultMerger() {
        resultsToMerge = new ArrayDeque<>();
    }
    
    protected void append(SLogoResult result) {
        resultsToMerge.add(result);
    }
    
    protected SLogoResult mergeAndReturn() {
        SLogoResult topResult = resultsToMerge.pop();
        while (!resultsToMerge.isEmpty()) {
            SLogoResult nextResult = resultsToMerge.pop();
            topResult.getTransition().addAll(nextResult.getTransition());
        }
        return topResult;
    }
}
