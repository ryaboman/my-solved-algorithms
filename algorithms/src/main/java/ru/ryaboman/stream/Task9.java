package ru.ryaboman.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task9 {
    //Сгруппировать слова по длине.
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "pear", "fig", "plum");
        Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }
}
