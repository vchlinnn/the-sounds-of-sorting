/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.soundsofsorting.sorts;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class SortsTest {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true if <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Generates a set of test cases to check sorting algorithms.
     */
    public static Integer[][] testCases() {
        return new Integer[][] {
            {3, 7, 9, 1, 2, 18, 16, 15, 19, 8, 14, 12, 5, 13, 4, 6, 0, 17, 11, 10}, // Random Order
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, // Already Sorted
            {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, // Reverse Sorted
            {5, 1, 5, 1, 5, 1, 5, 1}, // Duplicates
            {} // Empty Array
        };
    }

     /**
     * A method that takes a sorting function and tests both:
     * - The algorithm correctly sorts the array.
     * - The recorded events also sort the array correctly when replayed.
     */
    public void testSortWithEvents(String sortName, SortingFunction<Integer> sorter) {
        // for each loop
        for (Integer[] testCase : testCases()) {
            Integer[] original = testCase.clone();
            Integer[] sortedByAlgorithm = testCase.clone();

            // Run sorting algorithm and get the event log
            List<SortEvent<Integer>> events = sorter.sort(sortedByAlgorithm);
            assertTrue(sorted(sortedByAlgorithm), "failed sort " + sortName + " failed array " + Arrays.toString(testCase));

            // Replay the events on a copy of the original
            Integer[] replayed = original.clone();
            Sorts.eventSort(replayed, events);
            assertArrayEquals(sortedByAlgorithm, replayed,
            "failed sort " + sortName +  " failed array " + Arrays.toString(testCase));
        }
    }

    // Define a functional interface to support passing sort functions that return List<SortEvent<T>>
    public interface SortingFunction<T> {
        List<SortEvent<T>> sort(T[] array);
    }

    @Test
    public void testBubbleSort() {
        testSortWithEvents("BubbleSort", Sorts::bubbleSort);
    }

    @Test
    public void testInsertionSort() {
        testSortWithEvents("InsertionSort", Sorts::insertionSort);
    }

    @Test
    public void testSelectionSort() {
        testSortWithEvents("SelectionSort", Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSortWithEvents("MergeSort", Sorts::mergeSort);
    }

    @Test
    public void testQuickSort() {
        testSortWithEvents("MergeSort", Sorts::mergeSort);
    }
}