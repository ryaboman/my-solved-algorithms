package ru.ryaboman.stream;

import java.util.List;

public class Task17 {

    public static void main(String[] args) {
        Book book1 = new Book(1, "111");
        Book book2 = new Book(2, "222");
        Book book3 = new Book(3, "333");
        Book book4 = new Book(4, "444");

        Reader reader1 = new Reader(1, "reader1", List.of(book1, book4));
        Reader reader2 = new Reader(2, "reader2", List.of(book2, book3));
        Reader reader3 = new Reader(3, "reader3", List.of(book2, book4));
        Reader reader4 = new Reader(4, "reader4", List.of(book3, book4, book2));

        List<Reader> readers = List.of(reader1, reader2,reader3,reader4);
        System.out.println(findReadersByBookName(readers, "333"));

    }

    //вернуть читателей у которых книга с некоторым названием

    private static List<Reader> findReadersByBookName(List<Reader> readers,String bookName){
        return readers.stream()
                .filter( r -> r.getBooks()
                        .stream()
                        .anyMatch(b -> b.getName().equals(bookName)) )
                .toList();
    }

    static class Reader{
        private int id;
        private String name;
        private List<Book> books;

        public Reader(int id, String name, List<Book> books) {
            this.id = id;
            this.name = name;
            this.books = books;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Book> getBooks() {
            return books;
        }

        @Override
        public String toString() {
            return "Reader{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", books=" + books +
                    '}';
        }
    }

    static class Book{
        private int id;
        private String name;

        public Book(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
