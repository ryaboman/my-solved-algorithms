package ru.ryaboman.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Task11 {
    //Есть список заказов `Order` с полями `customerId` (int) и `amount` (double).
    //Нужно сгруппировать суммы заказов по клиентам, но учитывать только заказы с суммой больше 100. Вернуть Map\<customerId, totalAmount>.

    record Order(int customerId, double amount) {}

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, 120),
                new Order(2, 50),
                new Order(1, 80),
                new Order(3, 200),
                new Order(2, 150)
        );


        orders.stream()
                .filter(x -> x.amount > 100)
                .collect(
                        Collectors.groupingBy(
                                Order::customerId,
                                Collectors.summingDouble(Order::amount)
                        )
                );
    }
}
