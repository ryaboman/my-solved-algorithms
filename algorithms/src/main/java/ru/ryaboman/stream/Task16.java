package ru.ryaboman.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task16 {

    record User(String name, int age, String gender) {}

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Ivan", 22, "male"),
                new User("Oleg", 22, "male"),
                new User("Aleksey", 25, "male"),
                new User("Anna", 25, "female"),
                new User("Olga", 25, "female"),
                new User("Dmitry", 30, "male")
        );

        System.out.println("1. сгруппировать пользователей по возрасту и полу:");

        Map<Integer, Map<String, List<User>>> nestedGrouped = users.stream()
                        .collect(Collectors.groupingBy(
                                User::age,
                                Collectors.groupingBy(User::gender, Collectors.toList())
                                )
                        );

        System.out.println(nestedGrouped);

        System.out.println("2. узнать, сколько мужчин и женщин в списке:");

        Map<String, Long> countGender = users.stream()
                        .collect(Collectors.groupingBy(
                                User::gender,
                                Collectors.counting()
                        ));
        System.out.println(countGender);


        System.out.println("3. сгруппировать пользователей по полу, а внутри каждой группы — по возрасту:");
        Map<String, Map<Integer, List<User>>> groupedFirstGender = users.stream()
                .collect(Collectors.groupingBy(
                                User::gender,
                                Collectors.groupingBy(User::age, Collectors.toList())
                        )
                );
        System.out.println(groupedFirstGender);

    }

}
