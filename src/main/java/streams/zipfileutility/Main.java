package streams.zipfileutility;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] data = {
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5"
        };

        try (FileSystem zipFS = openZip(Paths.get("myData.zip")) ) {
            copyToZip(zipFS);
            writeToFileInZip1(zipFS,data);
            writeToFileInZip2(zipFS,data);
        }
        catch (Exception e ) {
            System.out.println(e.getClass().getSimpleName()+    " - " + e.getMessage());
        }

    }

    public static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create","true");

        URI zipUri = new URI("jar:file",zipPath.toUri().getPath(),null);

        FileSystem zipFS = FileSystems.newFileSystem(zipUri,providerProps);

        return zipFS;
    }

    public static void copyToZip(FileSystem zipFS) throws IOException {
        Path sourceFile = Paths.get("file1.txt");
        // Full code to get the file from the existing file system
        //Path sourceFile2 = FileSystems.getDefault().getPath("file1.txt");
        Path destFile = zipFS.getPath("/file1Copied.txt");

        Files.copy(sourceFile,destFile, StandardCopyOption.REPLACE_EXISTING);
    }

//    public static FileSystem closeZip(Path zipPath) throws IOException, URISyntaxException {
//
//    }

    public static void writeToFileInZip1(FileSystem zipFS, String[] data) throws IOException {
        try(BufferedWriter writer = Files.newBufferedWriter(zipFS.getPath("/newfile1.txt"))) {
            for (String d:
                 data) {
                writer.write(d);
                writer.newLine();
            }
        }

    }

    public static void writeToFileInZip2(FileSystem zipFS, String[] data) throws IOException {
        Files.write(zipFS.getPath("newfile2.txt"), Arrays.asList(data),
                Charset.defaultCharset(), StandardOpenOption.CREATE);
    }

}
