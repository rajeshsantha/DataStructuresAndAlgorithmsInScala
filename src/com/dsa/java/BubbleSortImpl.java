package com.dsa.java;

public class BubbleSortImpl {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        System.out.println("**********BubbleSort Java**********");
        System.out.println("Unsorted array");
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }
        System.out.println("\n Sorted array - By BubbleSort ");

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
