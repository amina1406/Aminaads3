package com.company;

public class Qsort<T extends Comparable<? super T>> {


    public void quicksort(T[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(array, startIndex, endIndex);
            quicksort(array, startIndex, pivotIndex);
            quicksort(array, pivotIndex + 1, endIndex);
        }
    }

    private int partition(T[] array, int l, int r) {
        int pivotIndex = (l + r) / 2;
        T pivotValue = array[pivotIndex];
        l--;
        r++;

        while (true) {
            do l++; while (array[l].compareTo(pivotValue) < 0);
            do r--; while (array[r].compareTo(pivotValue) > 0);
            if (l >= r) return r;
            T temp = array[l];
            array[l] = array[r];
            array[r] = temp;
        }
    }
}
