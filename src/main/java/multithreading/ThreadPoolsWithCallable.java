package multithreading;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class ThreadPoolsWithCallable {

    public static void main(String[] args) {

        //This is a simple task wherein we read a bunch of files and count the number of lines in each and
        //output them to a subsequent output file.
        Instant start = Instant.now();
        String[] inFiles = {"src/main/resources/MultiThreading/f1.txt"
                , "src/main/resources/MultiThreading/f2.txt"
                , "src/main/resources/MultiThreading/f3.txt"
                , "src/main/resources/MultiThreading/f4.txt"
                , "src/main/resources/MultiThreading/f5.txt"
                , "src/main/resources/MultiThreading/f6.txt"};
        String[] outFiles = {"src/main/resources/MultiThreading/f1_out.txt"
                , "src/main/resources/MultiThreading/f2_out.txt"
                , "src/main/resources/MultiThreading/f3_out.txt"
                , "src/main/resources/MultiThreading/f4_out.txt"
                , "src/main/resources/MultiThreading/f5_out.txt"
                , "src/main/resources/MultiThreading/f6_out.txt"};

        ExecutorService es = Executors.newFixedThreadPool(3);

        //Create futures to get the result
        Future<Integer>[] results = new Future[inFiles.length];

        for (int i = 0; i < inFiles.length; i++) {
            AdderWithCallable adder= new AdderWithCallable(inFiles[i], outFiles[i]);
            results[i] = es.submit(adder);
        }

        for (Future<Integer> result:
             results) {
            try {
                int value = result.get(); // blocks until return value available
                System.out.println("Total: " + value);
            } catch (ExecutionException e) { // Exception raised in Adder
                Throwable adderEx = e.getCause(); //Get the adder exception
                //Do something we need with adderEx
            } catch (Exception e) { // Non-adder exceptions
                System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
            }
        }

        es.shutdown();
        System.out.println("Elapsed Time(MilliSeconds): " + (Duration.between(start,Instant.now()).toMillis() ));

    }

}

/**
 * Changing the implementation of doAdd() to return back the total
 * instead of writing to a file
 *
 * This makes our class to run the background task and return the result
 *
 */
@AllArgsConstructor
@Getter
@Setter
class AdderWithCallable implements Callable<Integer> {

    private String inFile, outFile;

    public int doAdd() throws IOException {
        int total = 0;
        String line = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while ((line = reader.readLine()) != null)
                total++;
        }

        return total;
    }

    @Override
    public Integer call() throws IOException {
        return doAdd();
    }
}