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

public class ThreadingBasic {

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
        Thread[] threads = new Thread[inFiles.length];
        for (int i = 0; i < inFiles.length; i++) {
            AdderWithThreading adder = new AdderWithThreading(inFiles[i], outFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        for (Thread th:
             threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Takes 10 milliseconds which is 3ms faster than SingleThreading
        System.out.println("Elapsed Time(MilliSeconds): " + (Duration.between(start,Instant.now()).toMillis() ));

    }

}

@AllArgsConstructor
@Getter
@Setter
class AdderWithThreading implements Runnable {

    private String inFile, outFile;

    public void doAdd() throws IOException {
        int total = 0;
        String line = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while ((line = reader.readLine()) != null)
                total++;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))) {
            writer.write(String.valueOf(total));
        }
    }

    @Override
    public void run() {
        try {
            doAdd();
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
        }
    }
}