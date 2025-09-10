package ru.ryaboman.stream;

import java.util.List;

public class Task4 {
    //Сортировка строк по алфавиту
    public static void main(String[] args) {
        List<String> words = List.of("banana", "apple", "cherry");
        words.stream().sorted().forEach(System.out::println);
    }
}
