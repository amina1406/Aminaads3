package com.company;

public class Main {
    public static void main(String[] args)
    {
        String[] arrayOfStrings = {"Andree", "Damir", "John", "Anna", "Zhasmina", "Emilia", "Aruzhan"};
        Qsort<String> stringSorter   = new Qsort<>();
        stringSorter.quicksort(arrayOfStrings, 0, arrayOfStrings.length - 1);
        System.out.println(java.util.Arrays.toString(arrayOfStrings));

        Double[] arrayOfDoubles = {0.35,4.42,42.42,12.56,78.54,78.24};
        Qsort<Double> doubleSorter   = new Qsort<>();
        doubleSorter.quicksort(arrayOfDoubles, 0, arrayOfDoubles.length - 1);
        System.out.println(java.util.Arrays.toString(arrayOfDoubles));

        System.out.println("\n\n\n\n");

        String[] arrayOfStrings2 = {"Andree", "Damir", "John", "Anna", "Zhasmina", "Emilia", "Aruzhan"};
        Msort<String> mergeSortGeneric   = new Msort<>();
        mergeSortGeneric.mergeSort(arrayOfStrings2, 0, arrayOfStrings2.length - 1);
        System.out.println(java.util.Arrays.toString(arrayOfStrings2));

        Double[] arrayOfDoubles2 = {0.35,4.42,42.42,12.56,78.54,78.24};
        Msort<Double> doubleMergeSortGeneric   = new Msort<>();
        doubleMergeSortGeneric.mergeSort(arrayOfDoubles2, 0, arrayOfDoubles2.length - 1);
        System.out.println(java.util.Arrays.toString(arrayOfDoubles2));

        System.out.println("\n\n\n\n");


        HashMap<String, Integer> ht = new HashMap<>();
        ht.add("First", 25);
        ht.add("Second", 35);
        ht.add("Third", 13);
        ht.add("Forth", 5);
        ht.add("Fifth", 3);
        ht.add("Sixth", 42);
        System.out.println(ht.get("Second"));
    }


}

