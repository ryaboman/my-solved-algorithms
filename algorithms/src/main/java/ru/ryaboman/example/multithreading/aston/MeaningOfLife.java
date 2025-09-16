package ru.ryaboman.example.multithreading.aston;

import java.util.concurrent.*;

public class MeaningOfLife {

    private final ExecutorService executor = Executors.newFixedThreadPool(10);


    Future<Integer> findElseWhere(Integer currentAnswer){
        return executor.submit(() -> {
                Thread.sleep(1000L);
                return currentAnswer + 6;
        });
    }

    public CompletableFuture<Integer> exploreDifferentMeaning(Integer currentAnswer) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return currentAnswer + 10;
        });
    }


    static void announceAnswer(Integer answer){
        System.out.println(answer);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException{

        Integer answer = 42;
        MeaningOfLife meaningOfLife = new MeaningOfLife();
        Future<Integer> elseWhereAnswer = meaningOfLife.findElseWhere(answer);

        meaningOfLife.exploreDifferentMeaning(answer).thenAccept(MeaningOfLife::announceAnswer);

        announceAnswer(elseWhereAnswer.get());
        announceAnswer(elseWhereAnswer.get());
        announceAnswer(answer);

        Thread.sleep(3000L);
        meaningOfLife.executor.shutdown();

    }

}
