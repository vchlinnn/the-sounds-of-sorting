package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[][] makeTestArray() {
        return new Integer[][] {
            {3, 7, 9, 1, 2, 18, 16, 15, 19, 8, 14, 12, 5, 13, 4, 6, 0, 17, 11, 10}, // Random Order
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, // Already Sorted
            {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, // Reverse Sorted
            {5, 1, 5, 1, 5, 1, 5, 1}, // Duplicates
            {} // Empty Array
        };
    }

    // public void testSort(Consumer<Integer[]> func) {
    //     Integer[] arr = makeTestArray();
    //     func.accept(arr);
    //     assertTrue(sorted(arr));
    // }

     /**
     * A method that takes a sorting function and tests both:
     * - The algorithm correctly sorts the array.
     * - The recorded events also sort the array correctly when replayed.
     */
    public void testSort(SortingFunction<Integer> sorter) {
        // for each loop
        for (Integer[] testCase : makeTestArray()) {
            Integer[] original = testCase.clone();
            Integer[] sortedByAlgorithm = testCase.clone();

            // Run sorting algorithm and get the event log
            List<SortEvent<Integer>> events = sorter.sort(sortedByAlgorithm);
            assertTrue(sorted(sortedByAlgorithm), " failed array " + Arrays.toString(testCase));

            // Replay the events on a copy of the original
            Integer[] replayed = original.clone();
            Sorts.eventSort(replayed, events);
            assertArrayEquals(sortedByAlgorithm, replayed,
            " failed array " + Arrays.toString(testCase));
        }
    }

    // Define a functional interface to support passing sort functions that return List<SortEvent<T>>
    public interface SortingFunction<T> {
        List<SortEvent<T>> sort(T[] array);
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }
}