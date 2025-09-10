package ru.ryaboman.stream;

import java.util.Comparator;
import java.util.List;

public class Task7 {
    //Найти самое длинное слово в списке
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Programming", "Stream", "API");
        String word = words.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(word);
    }
}
