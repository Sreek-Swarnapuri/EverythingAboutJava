package generics.classes_interfaces;

import generics.collections.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExamples {

    public static void main(String[] args) {

        Person p1 = new Person("Hay Ward", 65);
        Person p2 = new Person("Tom Mitch", 59);
        Person p3 = new Person("Web Colt", 45);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        System.out.println("---without soring---");
        System.out.println(people);

        Collections.sort(people, new AgeComparator());

        System.out.println("---with soring---");
        System.out.println(people);

        System.out.println("--reverse sorting using anonymous class--");
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -1 * Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        System.out.println(people);

        System.out.println("--soring again using lambda--");
        // reverse order: Collections.sort(people, (o1, o2) -> -1 * Integer.compare(o1.getAge(), o2.getAge()));
        // normal order: Collections.sort(people,(o1,o2) -> Integer.compare(o1.getAge(),o2.getAge()));
        Collections.sort(people, Comparator.comparingInt(Person::getAge));
        System.out.println(people);

        System.out.println("--reverse soring again using lambda--");
        Collections.sort(people, Comparator.comparing(Person::getAge).reversed());
        System.out.println(people);


    }

}
