package multithreading.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {


    public static void main(String[] args) {

        //Single thread using Executor Service
        System.out.println("--SingleThread start--");
        callSingleThread();

        // Multi Threads - 10
        callMultiThreads(10);

    }

    private static void callMultiThreads(int i) {

        ExecutorService service = Executors.newFixedThreadPool(i);

        for (int k = 0; k < 10; k++) {
            service.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.format("Multi thread with thread name: %s, execution at %d ", Thread.currentThread().getName(), j);
                    System.out.println();
                }
            });
        }
        service.shutdown();
    }

    private static void callSingleThread() {

        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Single Thread execution at: " + i);
            }
            System.out.println("--Single Thread end--");
        });

        service.shutdown();

    }

}
