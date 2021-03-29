package io.streams;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable {

    public void saySomething() throws IOException {
        System.out.println("Something from Autocloseable ");
        throw new IOException("From myautoclose - saySomething");
    }

    @Override
    public void close() throws IOException {
        System.out.println("close");
        throw new IOException("From myautoclose - close");
    }

}
