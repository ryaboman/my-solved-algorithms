package ru.ryaboman.example.multithreading;

public class SynchronizedExampleClass {

    volatile static int counter = 0;

    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            SynchronizedExampleClass.increment();
        }
    }
}
