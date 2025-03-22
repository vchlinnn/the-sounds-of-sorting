/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.soundsofsorting.sorts;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

/**
 *
 * @author chucl
 */
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
     * Generates a diverse set of test cases to check sorting algorithms.
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
     * Runs a sorting function on all test cases and checks if the output is sorted.
     */
    public void testSort(Consumer<Integer[]> func) {
        for (Integer[] testCase : testCases()) {
            Integer[] arr = testCase.clone(); // Clone to prevent modifying original
            func.accept(arr);
            assertTrue(sorted(arr), "Array not sorted correctly: " + java.util.Arrays.toString(arr));
        }
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