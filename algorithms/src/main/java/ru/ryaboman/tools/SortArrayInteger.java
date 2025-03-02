package ru.ryaboman.tools;

import java.util.Arrays;

public class SortArrayInteger {
    public static void merge(Integer[] array) {
        Integer[] buffer = new Integer[array.length];
        merge(array, buffer, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void merge(Integer[] array, Integer[] buffer, Integer beginIndex, Integer endIndex) {
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
