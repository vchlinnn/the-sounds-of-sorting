package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;


/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {
    private int i;
    private int j;

    /**
     * Compare events created by the sort
     * @param i the first index
     * @param j the second index
     */
    public CompareEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * apply the event to the array
     * @param arr the array to apply the event to
     */
    public void apply(T[] arr) {
    }

    /**
     * get the affected indices of the event
     * @return a list of the indices
     */
    public List<Integer> getAffectedIndices() {
        return Arrays.asList(i, j);
    }

    /**
     * emphasize is false
     * @return false
     */
    public boolean isEmphasized() {
        return false;
    }
}
