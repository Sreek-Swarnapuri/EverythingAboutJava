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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPools {

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


        ExecutorService es = Executors.newFixedThreadPool(6);

        for (int i = 0; i < inFiles.length; i++) {
            AdderWithThreading adder= new AdderWithThreading(inFiles[i], outFiles[i]);
            es.submit(adder);
        }

        try {
            es.shutdown();
            if(!es.awaitTermination(5, TimeUnit.SECONDS))
                es.shutdownNow();
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
            es.shutdownNow();
        }

        System.out.println("Elapsed Time(MilliSeconds): " + (Duration.between(start,Instant.now()).toMillis() ));

    }

}