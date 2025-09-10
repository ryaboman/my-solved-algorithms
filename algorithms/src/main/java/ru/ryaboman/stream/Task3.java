package ru.ryaboman.stream;

import java.util.List;

public class Task3 {
    //Преобразовать строки в верхний регистр
    public static void main(String[] args) {
        List<String> names = List.of("anna", "bob", "kate");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
