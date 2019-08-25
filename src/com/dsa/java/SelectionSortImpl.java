package com.dsa.java;

public class SelectionSortImpl {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        System.out.println("**********Selection Sort Java**********");
        System.out.println("Unsorted array");
        for (int e:intArray) System.out.println(e);
        for (int lastUnsortedIndex=intArray.length-1;lastUnsortedIndex>0;lastUnsortedIndex--)
        {
            int largest=0;
            for (int i =0 ; i<=lastUnsortedIndex;i++)
            {
                if(intArray[i]>intArray[largest])
                {
                    largest=i;
                }
            }
            swap(intArray,largest,lastUnsortedIndex);

        }

        System.out.println("Sorted Array  - By Selection Sort Java");
        for (int e:intArray) System.out.println(e);

    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
