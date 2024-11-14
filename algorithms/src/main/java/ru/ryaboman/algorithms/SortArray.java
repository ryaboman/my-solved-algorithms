package ru.ryaboman.algorithms;

import java.util.Arrays;

public class SortArray {
    public static void merge(int[] array) {
        int[] buffer = new int[array.length];
        merge(array, buffer, 0, array.length - 1);
    }

    private static void merge(int[] array, int[] buffer, Integer beginIndex, Integer endIndex) {
        if(beginIndex < endIndex) {
            int indexMiddle = (beginIndex + endIndex) / 2;

            merge(array, buffer, beginIndex, indexMiddle);
            merge(array, buffer, indexMiddle+1, endIndex);

            //Здесь мы заранее знаем, что первый подмассив равен или длинее второго
            for(int i = beginIndex, bi = beginIndex, ei = indexMiddle+1; i <= endIndex; i++) {
                if(bi > indexMiddle || (ei <= endIndex && array[bi] > array[ei])) {
                    buffer[i] = array[ei];
                    ei++;
                }
                else {
                    buffer[i] = array[bi];
                    bi++;
                }
            }
            if (endIndex + 1 - beginIndex >= 0)
                System.arraycopy(buffer, beginIndex, array, beginIndex, endIndex + 1 - beginIndex);
        }


    }
}
