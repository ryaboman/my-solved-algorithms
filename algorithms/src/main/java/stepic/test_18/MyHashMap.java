package stepic.test_18;

import java.util.*;

public class MyHashMap<V, K> extends HashMap<K, V> {
    @Override
    public V get(Object key) {
        V value = super.get(key);
        try{
            if (value == null) {
                value = (V)Collections.emptyList();
            }
        } catch (ClassCastException e) { }
        return value;
    }
}
