package com.khanhtran0111;

import java.util.List;

public class QuickSort {
    /**
     * using quicksort, rightmost pivot.
     */
    public static <T extends Comparable<T>> void sort(List<T> arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, pivot + 1, high);
            sort(arr, low, pivot - 1);
        }
    }

    /**
     * The default partitioning method uses rightmost element as pivot.
     */
    private static <T extends Comparable<T>> int partition(List<T> arr, int low, int high) {
        int pivot = low;
        T pivotVal = arr.get(high);
        for (int i = low; i < high; i++) {
            if (arr.get(i).compareTo(pivotVal) < 0) {
                swap(arr, i, pivot);
                pivot++;
            }
        }
        swap(arr, high, pivot);
        return pivot;
    }

    /**
     * Method to swap 2 elements of array at 2 indexes.
     */
    private static <T extends Comparable<T>> void swap(List<T> arr, int idx1, int idx2) {
        T tmp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, tmp);
    }
}
