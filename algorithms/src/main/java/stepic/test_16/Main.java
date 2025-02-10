package stepic.test_16;

import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Integer[] ints = {13, 16, 25, 62, 384, 745, 502, 200};
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        BiConsumer<Integer, Integer> biConsumer = (t, u) -> System.out.println(t + " " + u);
        findMinMax(Arrays.stream(ints), comparator, biConsumer);
        findMinMaxOther(Arrays.stream(ints), comparator, biConsumer);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.collect(Collectors.toList());
        T min = list.stream().min(order).orElse(null);
        T max = list.stream().max(order).orElse(null);
        minMaxConsumer.accept(min, max);
    }

    public static <T> void findMinMaxOther(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        MinMaxFinder<T> minMaxFinder = new MinMaxFinder<>(order);
        stream.forEach(minMaxFinder);
        minMaxConsumer.accept(minMaxFinder.min, minMaxFinder.max);
    }
}
