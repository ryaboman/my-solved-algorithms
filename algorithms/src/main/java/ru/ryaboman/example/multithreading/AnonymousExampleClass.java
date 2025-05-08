package ru.ryaboman.example.multithreading;

public class AnonymousExampleClass {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.setName("Anonymous Thread");
        //t.setDaemon(true);

        t.start();

        try{
            t.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("END");
    }
}
