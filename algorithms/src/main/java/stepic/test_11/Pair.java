package stepic.test_11;

import java.util.Objects;

class Pair<TYPE_A, TYPE_B> {
    TYPE_A first;
    TYPE_B second;

    public TYPE_A getFirst() {
        return first;
    }
    public TYPE_B getSecond() {
        return second;
    }

    private Pair(TYPE_A first, TYPE_B second) {
        this.first = first;
        this.second = second;
    }

    public static <TYPE_A, TYPE_B> Pair<TYPE_A, TYPE_B> of(TYPE_A first, TYPE_B second) {
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(this.second, ((Pair<?,?>) obj).second)
                && Objects.equals(this.first, ((Pair<?,?>) obj).first);
    }

    @Override
    public int hashCode() {
        return first.hashCode() ^ second.hashCode();
    }
}
