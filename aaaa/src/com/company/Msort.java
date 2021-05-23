package com.company;

class Msort<T extends Comparable<? super T>> {
    void mergeSort(T[] array, int l, int r) {

        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    void merge(T[] array, int l, int m, int r) {
        T[] L = (T[]) new Comparable[m - l + 1];
        T[] R = (T[]) new Comparable[r - m];
        for (int i = 0; i < L.length; ++i)
            L[i] = array[l + i];
        for (int i = 0; i < R.length; ++i)
            R[i] = array[m + 1 + i];
        int leftIndex = 0, rightIndex = 0;
        int currentIndex = l;
        while (leftIndex < L.length && rightIndex < R.length) {
            if (L[leftIndex].compareTo(R[rightIndex]) <= 0) {
                array[currentIndex] = L[leftIndex];
                leftIndex++;
            } else {
                array[currentIndex] = R[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }
        while (leftIndex < L.length) array[currentIndex++] = L[leftIndex++];
        while (rightIndex < R.length) array[currentIndex++] = R[rightIndex++];
    }

}
