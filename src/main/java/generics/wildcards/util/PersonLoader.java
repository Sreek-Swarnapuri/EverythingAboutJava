package generics.wildcards.util;

import generics.collections.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader {

    private final RandomAccessFile file;

    public PersonLoader(final File file) throws FileNotFoundException {

        this.file = new RandomAccessFile(file, "rw");

    }

    public Person load() throws ClassNotFoundException {

        try {

            // read the data from the Object file
            final String className = file.readUTF();
            final String personName = file.readUTF();
            final int age = file.readInt();

            // Using reflection to create a new instance of the loaded class from the constructor
            // This uses unbounded wild card where in the ? in Class object is a generic and is unbounded with the class retrieved from .forName()
            final Class<?> personClass = Class.forName(className);
            final Constructor<?> constructor = personClass.getConstructor(String.class, int.class);

            return (Person) constructor.newInstance(personName, age);

        } catch (IOException e) {

            return null;

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {

            e.printStackTrace();
            return null;

        }

    }

    /**
     * Demonstrates the usage of having lower bounded wild cards
     *  - Use lower  bounded wildcard when using it as parameter of a method and not in a Generic for class
     */
    public void loadAll(final List<? super Person> people) throws ClassNotFoundException {

        Person person;

        while ((person = load()) != null)
            people.add(person);

    }

}
