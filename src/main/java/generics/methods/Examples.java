package generics.methods;

import generics.classes_interfaces.AgeComparator;
import generics.collections.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Examples {

    public static void main(String[] args) {
        Person p1 = new Person("Hay Ward", 65);
        Person p2 = new Person("Tom Mitch", 59);
        Person p3 = new Person("Web Colt", 45);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        final Person youngestPerson = min(people, new AgeComparator());

        System.out.println(youngestPerson);

        List<Integer> numbers = Arrays.asList(1, 2, 3);

        System.out.println("Lowest Number: " + min(numbers, Integer::compare));

        /* Without Generics ->
        final Person youngestPerson =
                (Person) min(people, new AgeComparator());

        System.out.println(youngestPerson);

         */
    }

    public static <T> T min(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty())
            throw new IllegalArgumentException("List is empty!");

        T lowestElement = values.get(0);

        for (int i = 0; i < values.size(); i++) {
            final T element = values.get(i);

            if (comparator.compare(element, lowestElement) < 0)
                lowestElement = element;
        }

        return lowestElement;
    }

    /*
        Without generics
     */
    /*
    public static Object min(List values, Comparator comparator) {
        if(values.isEmpty())
            throw new IllegalArgumentException("List is empty!");

        Object lowestElement = values.get(0);

        for (int i = 0; i < values.size(); i++) {
            final Object element = values.get(i);

            if(comparator.compare(element,lowestElement) < 0)
                lowestElement = element;
        }

        return lowestElement;
    }
    */


}
