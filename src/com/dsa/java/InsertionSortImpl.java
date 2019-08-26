package com.dsa.java;

public class InsertionSortImpl {
    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        System.out.println("**********InsertionSort Java**********");
        System.out.println("Unsorted array");
        for (int e : intArray) System.out.println(e);


        for (int firstUnsortedIndex = 1; firstUnsortedIndex<intArray.length;firstUnsortedIndex++)
        {
            int newElement = intArray[firstUnsortedIndex];

            int i;
                    for (i = firstUnsortedIndex;i>0 && intArray[i-1]>newElement;i--)
                    {
                        intArray[i]= intArray[i-1];
                    }
                    intArray[i]=newElement;
        }

        System.out.println("Sorted array - By Insertion Sort");
        for (int e : intArray) System.out.println(e);


    }
}
