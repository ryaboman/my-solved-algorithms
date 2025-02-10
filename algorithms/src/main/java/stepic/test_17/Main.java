package stepic.test_17;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stream<String> stream = Stream.of(scanner.nextLine().split("[\\p{Punct}\\s]+"));
        Map<String, Long> fWord = stream.map(x -> x.toLowerCase()).filter(x -> x.length() > 0).collect(
                Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().sorted(new WordComparator()).limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry word : fWord.entrySet()) {
            System.out.println(word.getKey());
        }
    }
}
