package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private int i;
    private int j;

    public SwapEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void apply(T[] arr) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<Integer> getAffectedIndices() {
        return Arrays.asList(i, j);
    }

    public boolean isEmphasized() {
        return true;
    }
}


