package ru.ryaboman.example;

import java.util.*;

import static ru.ryaboman.tools.Print.*;

public class PrintingContainers{
    static Collection fill(Collection<String> collection){
        collection.add("крыса");
        collection.add("кошка");
        collection.add("собака");
        collection.add("собака");
        return collection;
    }

    static Map fill(Map<String, String> map){
        map.put("крыса", "Анфиса");
        map.put("кошка", "Мурка");
        map.put("собака", "Шарик");
        map.put("собака", "Бобик");
        return map;
    }

    public static void main(String[] args) {
        println(fill(new ArrayList<String>()).toString());
        println(fill(new LinkedList<String>()).toString());
        println(fill(new HashSet<String>()).toString());
        println(fill(new TreeSet<String>()).toString());
        println(fill(new LinkedHashSet<String>()).toString());

        println(fill(new HashMap<String, String>()).toString());
        println(fill(new TreeMap<String, String>()).toString());
        println(fill(new LinkedHashMap<String, String>()).toString());


    }
}
