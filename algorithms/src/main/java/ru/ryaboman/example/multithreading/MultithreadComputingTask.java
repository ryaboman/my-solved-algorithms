package ru.ryaboman.example.multithreading;

public class MultithreadComputingTask {
    static final int SIZE = 10_000_001;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) throws InterruptedException {

        long startTimeOneThread = System.currentTimeMillis();
        compute(arr);
        long endTimeOneThread = System.currentTimeMillis();
        System.out.println("Время обработки в одном потоке " + (endTimeOneThread - startTimeOneThread));


        long startTimeTwoThread = System.currentTimeMillis();

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[SIZE - HALF];

        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, HALF, arr2, 0, arr2.length);

        Thread threadFirst = new Thread(() -> compute(arr1));
        Thread threadSecond = new Thread(() -> compute(arr2));

        threadFirst.start();
        threadSecond.start();

        threadFirst.join();
        threadSecond.join();

        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, HALF, arr2.length);

        long endTimeTwoThread = System.currentTimeMillis();
        System.out.println("Время обработки в двух потоках " + (endTimeTwoThread - startTimeTwoThread));

    }

    public static void compute(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
