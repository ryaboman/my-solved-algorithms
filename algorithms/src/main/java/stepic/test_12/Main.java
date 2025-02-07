package stepic.test_12;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<T>();
        set1.stream().filter(x -> !set2.contains(x)).forEach(result::add);
        set2.stream().filter(x -> !set1.contains(x)).forEach(result::add);
        return result;
    }

    public static <T> Set<T> symmetricDifferenceOther(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> answer = new HashSet<>(set1);
        Set<T> help = new HashSet<>(set2);
        answer.removeIf(help::remove);
        answer.addAll(help);
        return answer;
    }

}
