package ru.ryaboman.stream;

import java.util.List;

public class Task1 {
    //Задача 1 — Фильтрация списка
    //Дан список строк. Вывести все строки длиной больше 5 символов.
    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "pear", "pineapple", "kiwi");
        strings.stream().filter(s -> s.length() > 5 ).forEach(System.out::println);
    }
}
