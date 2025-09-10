package ru.ryaboman.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Task0 {
    //Задача 0 — Преобразование элементов
    //Дан список чисел. Возвести каждое число в квадрат и вывести результат.

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(numbers);
        List<Integer> result = numbers.stream().map(n -> n*n).toList();
        System.out.println(result);
    }
}
