package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private int index;
    private T value;

    /**
     * Copy events created by the sort
     * @param index the index to copy to
     * @param value the value to copy
     */
    public CopyEvent(int index, T value) {
        this.index = index;
        this.value = value;
    }

    /**
     * apply the event to the array
     * @param arr the array to apply the event to
     */
    public void apply(T[] arr) {
        arr[index] = value;
    }

    /**
     * get the affected indices of the event
     * @return a list of the indices
     */
    public List<Integer> getAffectedIndices() {
        return Arrays.asList(index);
    }

    /**
     * emphasize is true
     * @return true
     */
    public boolean isEmphasized() {
        return true;
    }
}
