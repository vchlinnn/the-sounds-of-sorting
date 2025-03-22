package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private int index;
    private T value;

    public CopyEvent(int index, T value) {
        this.index = index;
        this.value = value;
    }

    public void apply(T[] arr) {
       arr[index] = value;
    }

    public List<Integer> getAffectedIndices() {
        return Arrays.asList(index);
    }

    public boolean isEmphasized() {
        return true;
    }
}
