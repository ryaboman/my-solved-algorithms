package ru.ryaboman.stream;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task10 {
    //Из списка пользователей создать Map\<id, имя>.

    record User(int id, String name) {}


    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Alice"),
                new User(2, "Bob"),
                new User(2, "Bob2"),
                new User(3, "Charlie")
        );

        Map<Integer, List<String>> map = users.stream()
                .collect(
                        Collectors.groupingBy(
                                User::id,
                                Collectors.mapping(User::name, Collectors.toList())
                        )
                );

        System.out.println(map);
    }
}
