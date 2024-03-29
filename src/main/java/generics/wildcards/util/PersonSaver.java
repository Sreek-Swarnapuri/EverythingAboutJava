package generics.wildcards.util;

import generics.collections.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {

    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public void save(Person person) throws IOException {
        file.writeUTF(person.getClass().getName());
        file.writeUTF(person.getName());
        file.writeInt(person.getAge());
    }

    /**
     * Demonstrates the usage of having upper bounded wild cards
     *  - Use upper bounded wildcard when using it as parameter of a method and not in a Generic for class
     */
    public void saveAll(final List<? extends  Person> people) throws IOException {
        for (Person person : people) {
            save(person);
        }
    }

}

