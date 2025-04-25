package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private int i;
    private int j;

    /**
     * Swap events created by the sort
     * @param i the first index
     * @param j the second index
     */
    public SwapEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Apply the event to the array
     * @param arr the array to apply the event to
     */
    public void apply(T[] arr) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Get the affected indices of the event
     * @return a list of the indices
     */
    public List<Integer> getAffectedIndices() {
        return Arrays.asList(i, j);
    }

    /**
     * Emphasize is true
     * @return true
     */
    public boolean isEmphasized() {
        return true;
    }
}


