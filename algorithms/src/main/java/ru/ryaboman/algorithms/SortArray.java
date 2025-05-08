package ru.ryaboman.algorithms;


import java.util.Comparator;
import java.util.List;

public class SortArray {
    public  static <TYPE> void merge(TYPE[] array) {
        TYPE[] buffer = (TYPE[]) new Object[array.length];
        Expression<Integer> func = (a, b)-> a > b;
        merge(array, buffer, 0, array.length - 1, func );
    }

    public static <TYPE> void merge(TYPE[] array, Expression fun) {
        TYPE[] buffer = (TYPE[]) new Object[array.length];
        merge(array, buffer, 0, array.length - 1, fun);
    }

    private static <TYPE> void merge(TYPE[] array, TYPE[] buffer, Integer beginIndex, Integer endIndex, Expression fun) {
        if(beginIndex < endIndex) {
            int indexMiddle = (beginIndex + endIndex) / 2;

            merge(array, buffer, beginIndex, indexMiddle, fun);
            merge(array, buffer, indexMiddle+1, endIndex, fun);

            //Здесь мы заранее знаем, что первый подмассив равен или длинее второго
            for(int i = beginIndex, bi = beginIndex, ei = indexMiddle+1; i <= endIndex; i++) {
                if(bi > indexMiddle || ( ei <= endIndex && fun.isMore(array[bi], array[ei]) )) {
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

    public static <TYPE> void insertionSort(List<TYPE> elements, Comparator<TYPE> comparator) {
        for(int i = 1; i < elements.size(); i++) {
            for(int j = i-1; j >= 0; j--) {
                if(comparator.compare(elements.get(j), elements.get(i)) > 0){
                    if(i != j) {
                        elements.add(j, elements.remove(i));
                    }
                    break;
                }
            }
        }
    }
}

