package ru.ryaboman.algorithms.fibonacci;

public class Main {
    public static void main(String[] args) {
        Generator.subsequences(50).map(x-> x.toString() + " ").forEach(System.out::print);

        System.out.println();
        long number = Generator.generate(50);
        System.out.println(number);
    }
}
