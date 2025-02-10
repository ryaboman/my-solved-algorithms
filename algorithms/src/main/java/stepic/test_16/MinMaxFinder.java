package stepic.test_16;

import java.util.Comparator;
import java.util.function.Consumer;

public class MinMaxFinder<T> implements Consumer<T> {

    private final Comparator<? super T> order;
    T min;
    T max;

    public MinMaxFinder(Comparator<? super T> order) {
        this.order = order;
    }

    @Override
    public void accept(T t) {
        if (min == null || order.compare(t, min) < 0) {
            min = t;
        }
        if (max == null || order.compare(max, t) < 0) {
            max = t;
        }
    }
}
