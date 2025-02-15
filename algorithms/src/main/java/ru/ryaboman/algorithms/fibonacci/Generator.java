package ru.ryaboman.algorithms.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Generator {
    static List<Long> fibNumbers;

    static{
        fibNumbers = new ArrayList<>();
        fibNumbers.add(0L);
        fibNumbers.add(1L);
    }

    public static void fillFibNumbers(int n){
        for (int i = fibNumbers.size(); i <= n; i++){
            fibNumbers.add((long) fibNumbers.get(i-1) + fibNumbers.get(i-2));
        }
    }

    public static long generate(int n) {
        long back2 = 0, back1 = 1;
        long next;
        if(n == 0){ return 0; }
        for(int i = 2; i < n; i++) {
            next = back1 + back2;
            back2 = back1;
            back1 = next;
        }
        return back1+back2;
    }

    public static Stream<Long> subsequences(int n) {
        fillFibNumbers(n);
        return fibNumbers.stream();
    }
}
