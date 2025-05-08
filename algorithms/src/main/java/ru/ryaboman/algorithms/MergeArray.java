package ru.ryaboman.algorithms;

import java.util.Arrays;
import java.util.List;

public class MergeArray
{
    public static void main(String[] args) {
        String[] arr = new String[]{"1029207", "Simple-string", "Java"};//(Integer[]) mergeArrays(new int[]{1, 3}, new int[]{0, 1, 2, 5, 6});
        System.out.println(Arrays.toString(arr));
        Expression<String> func = (a, b)-> a.length() > b.length();
        SortArray.merge(arr, func);
        System.out.println(Arrays.toString(arr));

        String[] arr1 = new String[]{"1029asdf207", "Simple-str58555ing", "Java"};
        List<String> list = Arrays.asList(arr1);
        SortArray.insertionSort(list, (a, b)-> { if (a.length() > b.length()) return 1; return -1;});
        System.out.println(list);
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
