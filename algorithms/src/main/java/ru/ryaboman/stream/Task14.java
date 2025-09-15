package ru.ryaboman.stream;

import java.util.List;

public class Task14 {
    //Дан список чисел. Нужно найти произведение всех чисел больше 2. Если таких нет — вернуть 1.

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        long multimp = numbers.stream()
                .filter(x -> x > 2)
                .reduce(1, (x, y) -> x*y);

        System.out.println(multimp);
    }

}
