package ru.ryaboman.algorithms;

import java.util.Arrays;

public class MergeArray
{
    public static void main(String[] args) {
        int[] arr = mergeArrays(new int[]{1, 3}, new int[]{0, 1, 2, 5, 6});
        System.out.println(Arrays.toString(arr));
        SortArray.merge(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] newArray = new int[a1.length + a2.length];
        int maxLength = Math.max(a1.length, a2.length);

        for(int index = 0; index< maxLength; index++){
            if(index < a1.length) {
                newArray[index] = a1[index];
            }
            if(index < a2.length) {
                newArray[index + a1.length] = a2[index];
            }
        }

        return newArray;
    }
}