package ru.ryaboman.stream;

import java.util.List;

public class Task16 {
    // 1. сгруппировать пользователей по возрасту и полу.

    // 2. узнать, сколько мужчин и женщин в списке.

    // 3. сгруппировать пользователей по полу, а внутри каждой группы — по возрасту.

    record User(String name, int age, String gender) {}

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Ivan", 22, "male"),
                new User("Oleg", 22, "male"),
                new User("Anna", 25, "female"),
                new User("Olga", 25, "female"),
                new User("Dmitry", 30, "male")
        );



        //users.
        System.out.println(nestedGrouped);
    }

}
