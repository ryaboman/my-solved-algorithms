package ru.ryaboman.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Task20 {

    private static int count = 1;

    public static void main(String[] args) {
        SequenceList sequenceList = new SequenceList(List.of(
                getSequence(), // 1
                getSequence(), // 2
                getSequence() // 3
        ));

        SequenceMap sequenceMap = new SequenceMap(
                Map.of(
                        1, getSequence(), // 4
                        3, getSequence(), // 5
                        2, getSequence(), // 6
                        5, getSequence() // 7
                )
        );

        Predicate<String> predicate = str -> str.equals("show me");
        Predicate<String> predicate1 = str -> str.equals("hide me");

        SequenceMapBundle sequenceMapBundle = new SequenceMapBundle(
                Map.of(
                        predicate, new SequenceBundle(getSequence()), // 8
                        predicate1, new SequenceBundle(getSequence()) // 9
                )
        );

        Sequence sequence = getSequence();
        Sequence sequence1 = getSequence();
        Sequence sequence2 = getSequence();


        //Собрать все в один стрим и вывести в output:

        //Первый вариант
        Stream.of(sequenceList.getSequences().stream(),
                sequenceMap.getMap().values().stream(),
                sequenceMapBundle.getMap().values().stream().map(x -> x.getSequence()),
                Stream.of(sequence, sequence1, sequence2)
        ).flatMap(Function.identity()).forEach(s -> System.out.println(((Sequence)s).getOrder()));

        System.out.println("----------------");

        //Второй вариант
        Stream.concat(
                Stream.concat(
                        sequenceList.getSequences().stream(),
                        sequenceMap.getMap().values().stream()
                ),
                Stream.concat(
                        sequenceMapBundle.getMap().values().stream().map(x -> x.getSequence()),
                        Stream.of(sequence, sequence1, sequence2)
                )
        ).forEach(s -> System.out.println(s.getOrder()));

    }

    private static Sequence getSequence() {
        return new Sequence(count++);
    }


    private static class Sequence {
        private final int order;
        public Sequence(int order) {
            this.order = order;
        }
        public int getOrder() {
            return this.order;
        }
    }

    private static class SequenceList {
        private final List<Sequence> sequences;
        private SequenceList(List<Sequence> sequences) {
            this.sequences = sequences;
        }
        public List<Sequence> getSequences() {
            return sequences;
        }
    }

    private static class SequenceMap {
        private final Map<Integer, Sequence> sequenceMap;
        private SequenceMap(Map<Integer, Sequence> sequenceMap) {
            this.sequenceMap = sequenceMap;
        }
        public Map<Integer, Sequence> getMap() {
            return sequenceMap;
        }
    }

    private static class SequenceMapBundle {
        private final Map<Predicate<String>, SequenceBundle> sequenceBundleMap;
        private SequenceMapBundle(Map<Predicate<String>, SequenceBundle> sequenceBundleMap) {
            this.sequenceBundleMap = sequenceBundleMap;
        }
        public Map<Predicate<String>, SequenceBundle> getMap() {
            return sequenceBundleMap;
        }
    }

    private static class SequenceBundle {
        private final Sequence sequence;
        private SequenceBundle(Sequence sequence) {
            this.sequence = sequence;
        }
        public Sequence getSequence() {
            return this.sequence;
        }
    }

}
