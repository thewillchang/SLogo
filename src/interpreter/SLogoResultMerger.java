package interpreter;

import interpreter.result.SLogoResult;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Merges Expressions from a High Level in the Interpreter
 * @author Will Chang
 *
 */

public class SLogoResultMerger {

    private Deque<SLogoResult> myResultsToMerge;
    /**
     * Constructors
     */
    public SLogoResultMerger () {
        this(new ArrayDeque<>());
    }

    public SLogoResultMerger (Deque<SLogoResult> results) {
        myResultsToMerge = results;
    }

    /**
     * Adds an SLogoResult to be merged
     * @param result to be merged
     */
    protected void append (SLogoResult result) {
        myResultsToMerge.add(result);
    }

    /**
     * Merges all SLogoResults
     * @return one SLogo result containing all changes
     */
    protected SLogoResult mergeAndReturn () {
        SLogoResult topResult = myResultsToMerge.pop();
        while (!myResultsToMerge.isEmpty()) {
            SLogoResult nextResult = myResultsToMerge.pop();
            topResult.getTransition().addAll(nextResult.getTransition());
            topResult.setValue(nextResult.getValue());
        }
        return topResult;
    }
}
