package ru.ryaboman.example.multithreading;

public class DeadLockExampleClass {

    public static void main(String[] args) {
        Printer printer1 = new Printer();
        Printer printer2 = new Printer();

        printer1.setPrinter(printer2);
        printer2.setPrinter(printer1);

        Thread t1 = new Thread(printer1);
        Thread t2 = new Thread(printer2);

        t1.start();
        t2.start();
    }

}

class Printer implements Runnable {

    Printer printer;

    void setPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        defaultPrint();
    }

    public synchronized void defaultPrint() {
        System.out.println(Thread.currentThread().getName() + " - Захват своего монитора");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " - Попытка захвата чужого монитора");
        printer.print();
    }

    public synchronized void print(){
        System.out.println(Thread.currentThread().getName() + " - Захват чужого монитора");
        System.out.println("Печатаем на чужом принтере!");
    }
}
