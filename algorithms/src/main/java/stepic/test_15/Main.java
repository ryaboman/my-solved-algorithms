package stepic.test_15;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream intStream = pseudoRandomStream(13);
        for (int index = 0; index < 30; index++) {
            pseudoRandomStream(index).limit(30).mapToObj(x -> STR."\{x}, ").forEach(System.out::print);
            System.out.println();
        }
    }
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> ((x * x)/10)%1000);
    }
}
