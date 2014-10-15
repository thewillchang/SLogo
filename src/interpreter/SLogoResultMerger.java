package interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class SLogoResultMerger {

    private Deque<SLogoResult> resultsToMerge;
    
    public SLogoResultMerger() {
        resultsToMerge = new ArrayDeque<>();
    }
    
    /**
     * Adds an SLogoResult to be merged
     * @param result to be merged
     */
    protected void append(SLogoResult result) {
        resultsToMerge.add(result);
    }
    
    /**
     * Merges all SLogoResults
     * @return one SLogo result containing all changes
     */
    protected SLogoResult mergeAndReturn() {
        SLogoResult topResult = resultsToMerge.pop();
        while (!resultsToMerge.isEmpty()) {
            SLogoResult nextResult = resultsToMerge.pop();
            topResult.getTransition().addAll(nextResult.getTransition());
        }
        return topResult;
    }
}
