package ru.ryaboman.stream;

import java.util.List;

public class Task2 {
    //Фильтрация чётных чисел
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        nums.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }
}
