//package com.khanhtran0111;

import java.util.List;

public class Week11<T> {
    public static <T extends Comparable<T>> List<T> sortGeneric(List<T> arr) {
        QuickSort.sort(arr, 0, arr.size() - 1);
        return arr;
    }
}
