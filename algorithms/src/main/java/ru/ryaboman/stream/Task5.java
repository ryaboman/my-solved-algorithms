package ru.ryaboman.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    //Объединить строки в одну (через запятую)
    public static void main(String[] args) {
        List<String> words = List.of("a", "b", "c");
        //String result = String.join(", ", words);
        String result = words.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }
}
