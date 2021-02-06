package appExecutionAndEnvironment;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PassingFileNamesAsArguments {

    //If we have a file name with spaces, we should pass it with double quotes e.g. "multple part file name.txt"
    public static void main(String[] args) {
        if (args.length == 0) {
            showUsage();
            return;
        }

        String filename = args[0];
        if (!Files.exists(Paths.get(filename))) {
            System.out.println("\n File not found: " + filename);
            return;
        }

        showFileLines(filename);

    }

    private static void showUsage() {
        System.out.println();
        System.out.println("Please provide a filename to process on the command line");
    }

    private static void showFileLines(String filename) {
        System.out.println();

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filename))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

    }

}
