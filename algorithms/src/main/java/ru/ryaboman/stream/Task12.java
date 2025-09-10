package ru.ryaboman.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Task12 {
    //Есть список `Person` с полем `List<String> phoneNumbers`.
    //Нужно получить список уникальных телефонных номеров, которые начинаются с «+7».

    record Person(String name, List<String> phoneNumbers) {}

    public static void main(String[] args) {


        List<Person> people = List.of(
                new Person("Alice", List.of("+7123456789", "+123456789")),
                new Person("Bob", List.of("+7987654321", "+7123456789")),
                new Person("Charlie", List.of("+123123123"))
        );

        long count = people.stream().flatMap(p -> p.phoneNumbers.stream()).filter(s -> s.startsWith("+7")).distinct().count();
        System.out.println(count);
    }
}
