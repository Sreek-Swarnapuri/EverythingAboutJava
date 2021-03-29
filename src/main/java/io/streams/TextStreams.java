package io.streams;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class TextStreams {

    //Traditional try catch usage
    public static void doTryCatchFinally() {
        char[] buff = new char[8];
        int len;
        Reader reader = null;

        try {
            reader = Helper.openReader("main/resources/file.txt");
            while((len = reader.read(buff)) >=0)  {
                System.out.println("\nlength: " + len);
                for(int i=0; i<len;i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getClass().getSimpleName() + " - " + ioException.getMessage());
        } finally {
            try {
                System.out.println("in finally");
                if(reader!=null)
                    reader.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getClass().getSimpleName() + " - " + ioException.getMessage());
            }
        }

    }

    //with try with resources
    public static void doTryWithResources() {

        //length of the array specifies how many characters can be read at a time
        char[] buff = new char[8];
        int len;

        try(Reader reader = Helper.openReader("main/resources/file.txt")) {
            while((len = reader.read(buff)) >=0)  {
                System.out.println("\nlength: " + len);
                for(int i=0; i<len;i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getClass().getSimpleName() + " - " + ioException.getMessage());
        }

    }

    //with try with multiple resources
    public static void doTryWithResourcesMulti() {

        //length of the array specifies how many characters can be read at a time
        char[] buff = new char[8];
        int len;

        try(Reader reader = Helper.openReader("main/resources/file.txt");
                Writer writer = Helper.openWriter("main/resources/file1.txt")) {
            while((len = reader.read(buff)) >=0)  {
                System.out.println("\nlength: " + len);
                writer.write(buff,0,len);
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getClass().getSimpleName() + " - " + ioException.getMessage());
        }

    }

    public static void doCloseThing() {
        try(MyAutoCloseable myAutoCloseable = new MyAutoCloseable();) {
            myAutoCloseable.saySomething();
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage() );

            for(Throwable t: e.getSuppressed())
                System.out.println("Suppressed: " + t.getMessage() );
        }
    }

}
