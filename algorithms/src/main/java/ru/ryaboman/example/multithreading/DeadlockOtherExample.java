package ru.ryaboman.example.multithreading;

public class DeadlockOtherExample {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {

        Thread threadOne = new Thread(new DeadThreadOne());
        Thread threadTwo = new Thread(new DeadThreadTwo());
        threadOne.start();
        threadTwo.start();

    }

    private static class DeadThreadOne implements Runnable {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("DeadlockOne thread is holding lock1 ...");
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadlockOne thread try capture lock2 ...");
                synchronized (lock2) {
                    System.out.println("DeadlockOne thread is holding lock2 ...");
                }
            }
        }
    }

    private static class DeadThreadTwo implements Runnable {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("DeadThreadTwo thread is holding lock2 ...");
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadThreadTwo thread try capture lock1 ...");
                synchronized (lock1) {
                    System.out.println("DeadThreadTwo thread is holding lock1 ...");
                }
            }
        }
    }
}
