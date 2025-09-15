package ru.ryaboman.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Task19 {
    /*Написать программу для подсчета количества конкретных слов в строке используя хэш мар*/

    public static void main(String[] args) {
        String str = "This task task will be solved by by by Java developer developer ";
        System.out.println(findWordsWithGrouping(str));
    }

    private static Map<String, Long> findWordsWithGrouping(String str){
        return Arrays.stream(str.split(" "))
                .collect(
                        Collectors.groupingBy(w -> w, Collectors.counting())
                );
    }
}
