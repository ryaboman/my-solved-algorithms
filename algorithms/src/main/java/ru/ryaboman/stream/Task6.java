package ru.ryaboman.stream;

import java.util.List;

public class Task6 {
    //Пропустить первые 3 строки и взять следующие 5.
    public static void main(String[] args) {
        List<String> strings = List.of("a", "b", "c", "d", "e", "f", "g");
        strings.stream().skip(3).limit(5).forEach(System.out::println);
    }
}
