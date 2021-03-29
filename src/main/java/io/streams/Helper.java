package io.streams;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {

    public static Reader openReader(String path) throws IOException {
        return Files.newBufferedReader(Paths.get(path));
    }

    public static Writer openWriter(String path) throws IOException {
        return Files.newBufferedWriter(Paths.get(path));
    }

}
