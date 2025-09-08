package ru.ryaboman.example.multithreading;

public class TestParentChild {
    public static void main(String[] args) throws InterruptedException {
        Child child1 = new Child();
        Child child2 = new Child();

        Thread thread1 = new Thread(() -> {
            try {
                child1.doWork();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                child2.doWork();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class Parent {

    int i = 0;

    public synchronized void doWork() throws InterruptedException {
        System.out.println("Захват монитора");
        System.out.println(i++);
        Thread.sleep(500);
        System.out.println(i++);
        System.out.println("Parent work");
        System.out.println(this);
        doSomething();
    }

    public void doSomething() {
        System.out.println("doSomething Parent");
    }
}

class Child extends Parent {
    @Override
    public synchronized void doWork() throws InterruptedException {
        System.out.println("Child work");
        super.doWork();

    }

    @Override
    public void doSomething() {
        System.out.println("doSomething Child");
        super.doSomething();
    }
}