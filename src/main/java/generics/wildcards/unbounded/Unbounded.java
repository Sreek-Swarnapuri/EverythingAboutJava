package generics.wildcards.unbounded;

import generics.collections.Person;

import java.lang.reflect.Constructor;

public class Unbounded {

    Class<?> aClass;

    public Unbounded(Class<?> aClass) throws NoSuchMethodException {
        this.aClass = aClass;
    }
}
