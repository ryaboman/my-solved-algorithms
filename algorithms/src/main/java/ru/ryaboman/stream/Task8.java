package ru.ryaboman.stream;

import java.util.List;

public class Task8 {
    //Найти первую строку, начинающуюся с буквы «A».
    public static void main(String[] args) {
        List<String> strings = List.of("Apple", "banana", "Avocado", "cherry");
        String word = strings.stream().filter(w -> w.startsWith("A")).findFirst().orElse("--");
        System.out.println(word);
    }

}
