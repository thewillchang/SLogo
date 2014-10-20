package interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author Will
 *
 */

public class SLogoResultMerger {

    private Deque<SLogoResult> resultsToMerge;
    
    public SLogoResultMerger () {
        this(new ArrayDeque<>());
    }
    
    public SLogoResultMerger (Deque<SLogoResult> results) {
        resultsToMerge = results;
    }
    
    /**
     * Adds an SLogoResult to be merged
     * @param result to be merged
     */
    protected void append (SLogoResult result) {
        resultsToMerge.add(result);
    }
    
    /**
     * Merges all SLogoResults
     * @return one SLogo result containing all changes
     */
    protected SLogoResult mergeAndReturn () {
        SLogoResult topResult = resultsToMerge.pop();
        while (!resultsToMerge.isEmpty()) {
            SLogoResult nextResult = resultsToMerge.pop();
            topResult.getTransition().addAll(nextResult.getTransition());
            topResult.setValue(nextResult.getValue());
        }
        return topResult;
    }
}
