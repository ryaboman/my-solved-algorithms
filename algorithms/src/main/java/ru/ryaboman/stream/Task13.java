package ru.ryaboman.stream;

import java.util.Comparator;
import java.util.List;

public class Task13 {
    //Есть список `Product` с `name` и `price`.
    //Отсортировать по убыванию цены, если цена совпадает — по алфавиту названия. Взять топ-3 самых дорогих.

    record Product(String name, double price) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Pen", 1.50),
                new Product("Notebook", 5.75),
                new Product("Book", 12.99),
                new Product("Pencil", 1.50),
                new Product("Eraser", 0.99)
        );

        List<Product> productsAfterStream = products.stream().sorted(Comparator.comparing(Product::price).reversed().thenComparing(Product::name)).toList();
        System.out.println(productsAfterStream);
    }
}
