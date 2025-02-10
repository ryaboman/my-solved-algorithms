package stepic.test_17;

import java.util.Comparator;
import java.util.Map;

public class WordComparator implements Comparator<Map.Entry<String, Long>> {
    @Override
    public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
        if(o1.getValue().equals(o2.getValue())) {
            return o1.getKey().compareTo(o2.getKey());
        }
        return o2.getValue().compareTo(o1.getValue());
    }
}
